package com.dct.model.common;

import com.dct.model.constants.BaseHttpStatusConstants;
import com.dct.model.constants.BaseSecurityConstants;
import com.dct.model.dto.response.BaseResponseDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SecurityUtils {

    public static MvcRequestMatcher[] convertToMvcMatchers(MvcRequestMatcher.Builder mvc, String[] patterns) {
        return Stream.of(patterns)
            .map(mvc::pattern)
            .toList()
            .toArray(new MvcRequestMatcher[0]);
    }

    public static boolean checkIfAuthenticationRequired(String requestUri, String[] publicPatterns) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return Arrays.stream(publicPatterns).noneMatch(pattern -> antPathMatcher.match(pattern, requestUri));
    }

    public static boolean checkIfAuthenticationNotRequired(String requestUri, String[] publicPatterns) {
        PathPatternParser parser = new PathPatternParser();
        return Arrays.stream(publicPatterns)
                .map(parser::parse)
                .anyMatch(p -> p.matches(PathContainer.parsePath(requestUri)));
    }

    public static String retrieveToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String bearerToken = null;

        if (Objects.nonNull(cookies)) {
            bearerToken = Arrays.stream(cookies)
                    .filter(cookie -> BaseSecurityConstants.COOKIES.HTTP_ONLY_TOKEN.equals(cookie.getName()))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
        }

        if (!StringUtils.hasText(bearerToken))
            bearerToken = request.getHeader(BaseSecurityConstants.HEADER.AUTHORIZATION_HEADER);

        if (!StringUtils.hasText(bearerToken))
            bearerToken = request.getHeader(BaseSecurityConstants.HEADER.AUTHORIZATION_GATEWAY_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BaseSecurityConstants.HEADER.TOKEN_TYPE))
            return bearerToken.substring(BaseSecurityConstants.HEADER.TOKEN_TYPE.length());

        return bearerToken;
    }

    public static String retrieveTokenWebFlux(ServerHttpRequest request) {
        // Extract from Authorization header
        String authHeader = request.getHeaders().getFirst(BaseSecurityConstants.HEADER.AUTHORIZATION_HEADER);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith(BaseSecurityConstants.HEADER.TOKEN_TYPE)) {
            return authHeader.substring(BaseSecurityConstants.HEADER.TOKEN_TYPE.length());
        }

        // Extract from query parameter (for WebSocket)
        return request.getQueryParams().getFirst(BaseSecurityConstants.HEADER.AUTHORIZATION_WEBSOCKET);
    }

    public static String convertUnAuthorizeError(ServerHttpResponse response, String message) {
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        BaseResponseDTO responseDTO = BaseResponseDTO.builder()
                .code(BaseHttpStatusConstants.UNAUTHORIZED)
                .success(Boolean.FALSE)
                .message(message)
                .build();

        return JsonUtils.toJsonString(responseDTO);
    }
}
