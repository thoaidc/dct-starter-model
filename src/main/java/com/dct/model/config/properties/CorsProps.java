package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BasePropertiesConstants;
import com.dct.model.constants.BaseSecurityConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#CORS_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-dev.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.CORS_CONFIG)
public class CorsProps {
    private ActivateStatus activate = ActivateStatus.DISABLED;
    private Map<String, CorsMapping> patterns = new LinkedHashMap<>();

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public Map<String, CorsMapping> getPatterns() {
        return patterns;
    }

    public void setPatterns(Map<String, CorsMapping> patterns) {
        this.patterns = patterns;
    }

    public static class CorsMapping {
        private List<String> allowedOriginPatterns;
        private List<String> allowedOrigins = List.of(BaseSecurityConstants.CORS.DEFAULT_ALLOWED_ORIGIN_PATTERNS);
        private List<String> allowedMethods = List.of(BaseSecurityConstants.CORS.DEFAULT_ALLOWED_REQUEST_METHODS);
        private List<String> allowedHeaders = List.of(BaseSecurityConstants.CORS.DEFAULT_ALLOWED_HEADERS);
        private boolean allowCredentials = BaseSecurityConstants.CORS.DEFAULT_ALLOW_CREDENTIALS;
        private long maxAge = BaseSecurityConstants.CORS.DEFAULT_MAX_AGE;

        public List<String> getAllowedOriginPatterns() {
            return allowedOriginPatterns;
        }

        public void setAllowedOriginPatterns(List<String> allowedOriginPatterns) {
            this.allowedOriginPatterns = allowedOriginPatterns;
        }

        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }

        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = allowedOrigins;
        }

        public List<String> getAllowedMethods() {
            return allowedMethods;
        }

        public void setAllowedMethods(List<String> allowedMethods) {
            this.allowedMethods = allowedMethods;
        }

        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }

        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }

        public boolean getAllowCredentials() {
            return allowCredentials;
        }

        public void setAllowCredentials(boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }

        public long getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(long maxAge) {
            this.maxAge = maxAge;
        }
    }
}
