package com.dct.model.security;

import com.dct.model.config.properties.SecurityProps;
import com.dct.model.constants.BaseExceptionConstants;
import com.dct.model.constants.BaseSecurityConstants;
import com.dct.model.dto.auth.BaseUserDTO;
import com.dct.model.exception.BaseAuthenticationException;
import com.dct.model.exception.BaseBadRequestException;
import com.dct.model.exception.BaseIllegalArgumentException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public abstract class AbstractJwtProvider {
    private static final Logger log = LoggerFactory.getLogger(AbstractJwtProvider.class);
    private static final String ENTITY_NAME = "com.dct.model.security.filter.AbstractJwtProvider";
    protected final SecretKey accessTokenSecretKey;
    protected final JwtParser accessTokenParser;

    public AbstractJwtProvider(SecurityProps securityProps) {
        if (Objects.isNull(securityProps) || Objects.isNull(securityProps.getJwt())) {
            throw new BaseIllegalArgumentException(ENTITY_NAME, "JWT config must not be null");
        }

        SecurityProps.JwtConfig jwtConfig = securityProps.getJwt();
        String base64AccessTokenSecretKey = jwtConfig.getAccessToken().getBase64SecretKey();

        if (!StringUtils.hasText(base64AccessTokenSecretKey)) {
            throw new BaseIllegalArgumentException(ENTITY_NAME, "Could not found secret key to sign JWT");
        }

        log.debug("[JWT_SIGNATURE_AUTO_CONFIG] - Using a Base64-encoded JWT secret key");
        byte[] keyBytes = Base64.getUrlDecoder().decode(base64AccessTokenSecretKey);
        accessTokenSecretKey = Keys.hmacShaKeyFor(keyBytes);
        accessTokenParser = Jwts.parser().verifyWith(accessTokenSecretKey).build();
        log.debug("[JWT_SIGNATURE_AUTO_CONFIG] - Sign JWT with algorithm: {}", accessTokenSecretKey.getAlgorithm());
    }

    public Authentication validateAccessToken(String accessToken) {
        Claims claims = parseToken(accessTokenParser, accessToken);
        return getAuthentication(claims);
    }

    protected Claims parseToken(JwtParser parser, String token) {
        log.debug("[VALIDATE_TOKEN] - Validating token by default config");

        if (!StringUtils.hasText(token))
            throw new BaseBadRequestException(ENTITY_NAME, BaseExceptionConstants.BAD_CREDENTIALS);

        try {
            return parser.parseSignedClaims(token).getPayload();
        } catch (MalformedJwtException e) {
            log.error("[JWT_MALFORMED_ERROR] - Invalid JWT: {}", e.getMessage());
        } catch (SignatureException e) {
            log.error("[JWT_SIGNATURE_ERROR] - Invalid JWT signature: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("[JWT_EXPIRED_ERROR] - Expired JWT: {}", e.getMessage());
        } catch (JwtException e) {
            log.error("[JWT_SECURITY_ERROR] - Unable to decode JWT: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("[ILLEGAL_ARGUMENT_ERROR] - Invalid JWT string (null, empty,...): {}", e.getMessage());
        }

        throw new BaseAuthenticationException(ENTITY_NAME, BaseExceptionConstants.TOKEN_INVALID_OR_EXPIRED);
    }

    protected Authentication getAuthentication(Claims claims) {
        try {
            Integer userId = (Integer) claims.get(BaseSecurityConstants.TOKEN_PAYLOAD.USER_ID);
            String username = (String) claims.get(BaseSecurityConstants.TOKEN_PAYLOAD.USERNAME);
            String authorities = (String) claims.get(BaseSecurityConstants.TOKEN_PAYLOAD.AUTHORITIES);
            Set<SimpleGrantedAuthority> userAuthorities = Arrays.stream(authorities.split(","))
                    .filter(StringUtils::hasText)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
            BaseUserDTO principal = BaseUserDTO.userBuilder()
                    .withId(userId)
                    .withUsername(username)
                    .withAuthorities(userAuthorities)
                    .build();
            return new UsernamePasswordAuthenticationToken(principal, username, userAuthorities);
        } catch (Exception e) {
            log.error("[JWT_PROVIDER_GET_AUTHENTICATION_ERROR] - error: {}", e.getMessage());
            throw new BaseIllegalArgumentException(ENTITY_NAME, "Could not get authentication from token");
        }
    }
}
