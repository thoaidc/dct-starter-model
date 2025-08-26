package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.AuthenticationType;
import com.dct.model.constants.BasePropertiesConstants;
import com.dct.model.constants.BaseSecurityConstants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Optional;

/**
 * Contains security configurations such as the secret key<p>
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#SECURITY_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-dev.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.SECURITY_CONFIG)
public class SecurityProps {
    private ActivateStatus enabledTls = ActivateStatus.DISABLED;
    private AuthenticationType authenticationType = AuthenticationType.CUSTOM;
    private Integer passwordEncryptFactor;
    private String[] publicRequestPatterns;
    private JwtConfig jwt;
    private OAuth2Config oauth2;

    public ActivateStatus getEnabledTls() {
        return enabledTls;
    }

    public void setEnabledTls(ActivateStatus enabledTls) {
        this.enabledTls = enabledTls;
    }

    public Integer getPasswordEncryptFactor() {
        return passwordEncryptFactor;
    }

    public void setPasswordEncryptFactor(Integer passwordEncryptFactor) {
        this.passwordEncryptFactor = passwordEncryptFactor;
    }

    public String[] getPublicRequestPatterns() {
        return Optional.ofNullable(publicRequestPatterns)
                .orElse(BaseSecurityConstants.REQUEST_MATCHERS.DEFAULT_PUBLIC_API_PATTERNS);
    }

    public void setPublicRequestPatterns(String[] publicRequestPatterns) {
        this.publicRequestPatterns = publicRequestPatterns;
    }

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public JwtConfig getJwt() {
        return jwt;
    }

    public void setJwt(JwtConfig jwt) {
        this.jwt = jwt;
    }

    public OAuth2Config getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Config oauth2) {
        this.oauth2 = oauth2;
    }

    public static class JwtConfig {
        private AccessToken accessToken;
        private RefreshToken refreshToken;
        private String base64SecretKey;

        public AccessToken getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(AccessToken accessToken) {
            this.accessToken = accessToken;
        }

        public RefreshToken getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(RefreshToken refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getBase64SecretKey() {
            return base64SecretKey;
        }

        public void setBase64SecretKey(String base64SecretKey) {
            this.base64SecretKey = base64SecretKey;
        }

        public static class AccessToken {
            private Long validity;

            public Long getValidity() {
                return validity;
            }

            public void setValidity(Long validity) {
                this.validity = validity;
            }
        }

        public static class RefreshToken {
            private Long validity;
            private Long validityForRemember;

            public Long getValidity() {
                return validity;
            }

            public void setValidity(Long validity) {
                this.validity = validity;
            }

            public Long getValidityForRemember() {
                return validityForRemember;
            }

            public void setValidityForRemember(Long validityForRemember) {
                this.validityForRemember = validityForRemember;
            }
        }
    }

    public static class OAuth2Config {
        private ActivateStatus activate = ActivateStatus.DISABLED;
        private String baseAuthorizeUri;
        private List<OAuth2Config.ClientProps> clients;

        public ActivateStatus getActivate() {
            return activate;
        }

        public void setActivate(ActivateStatus activate) {
            this.activate = activate;
        }

        public String getBaseAuthorizeUri() {
            return baseAuthorizeUri;
        }

        public void setBaseAuthorizeUri(String baseAuthorizeUri) {
            this.baseAuthorizeUri = baseAuthorizeUri;
        }

        public List<OAuth2Config.ClientProps> getClients() {
            return clients;
        }

        public void setClients(List<OAuth2Config.ClientProps> clients) {
            this.clients = clients;
        }

        public static class ClientProps {
            private String provider;
            private String clientId;
            private String clientName;
            private String clientSecret;
            private String authorizationUri;
            private String redirectUri;
            private String tokenUri;
            private String userInfoUri;
            private String usernameAttributeName;
            private List<String> scope;

            public String getProvider() {
                return provider;
            }

            public void setProvider(String provider) {
                this.provider = provider;
            }

            public String getClientId() {
                return clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientName() {
                return clientName;
            }

            public void setClientName(String clientName) {
                this.clientName = clientName;
            }

            public String getClientSecret() {
                return clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }

            public String getAuthorizationUri() {
                return authorizationUri;
            }

            public void setAuthorizationUri(String authorizationUri) {
                this.authorizationUri = authorizationUri;
            }

            public String getRedirectUri() {
                return redirectUri;
            }

            public void setRedirectUri(String redirectUri) {
                this.redirectUri = redirectUri;
            }

            public String getTokenUri() {
                return tokenUri;
            }

            public void setTokenUri(String tokenUri) {
                this.tokenUri = tokenUri;
            }

            public String getUserInfoUri() {
                return userInfoUri;
            }

            public void setUserInfoUri(String userInfoUri) {
                this.userInfoUri = userInfoUri;
            }

            public String getUsernameAttributeName() {
                return usernameAttributeName;
            }

            public void setUsernameAttributeName(String usernameAttributeName) {
                this.usernameAttributeName = usernameAttributeName;
            }

            public List<String> getScope() {
                return scope;
            }

            public void setScope(List<String> scope) {
                this.scope = scope;
            }
        }
    }
}
