package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BasePropertiesConstants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#INTERCEPTOR_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-dev.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.INTERCEPTOR_CONFIG)
public class InterceptorProps {

    private CorsConfig cors;
    private ActivateStatus activate;
    private List<InterceptorConfig> chain;

    public CorsConfig getCors() {
        return cors;
    }

    public void setCors(CorsConfig cors) {
        this.cors = cors;
    }

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public List<InterceptorConfig> getChain() {
        return Optional.ofNullable(chain).orElse(Collections.emptyList());
    }

    public void setChain(List<InterceptorConfig> chain) {
        this.chain = chain;
    }

    public static class CorsConfig {
        private List<String> applyFor;
        private List<String> allowedOriginPatterns;
        private List<String> allowedHeaders;
        private List<String> allowedMethods;
        private Boolean allowedCredentials;

        public List<String> getApplyFor() {
            return applyFor;
        }

        public void setApplyFor(List<String> applyFor) {
            this.applyFor = applyFor;
        }

        public List<String> getAllowedOriginPatterns() {
            return allowedOriginPatterns;
        }

        public void setAllowedOriginPatterns(List<String> allowedOriginPatterns) {
            this.allowedOriginPatterns = allowedOriginPatterns;
        }

        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }

        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }

        public List<String> getAllowedMethods() {
            return allowedMethods;
        }

        public void setAllowedMethods(List<String> allowedMethods) {
            this.allowedMethods = allowedMethods;
        }

        public Boolean isAllowedCredentials() {
            return allowedCredentials;
        }

        public void setAllowedCredentials(Boolean allowedCredentials) {
            this.allowedCredentials = allowedCredentials;
        }
    }

    public static class InterceptorConfig {
        private Class<?> name;
        private String[] includedPatterns;
        private String[] excludedPatterns;

        public Class<?> getName() {
            return name;
        }

        public void setName(Class<?> name) {
            this.name = name;
        }

        public String[] getIncludedPatterns() {
            return includedPatterns;
        }

        public void setIncludedPatterns(String[] includedPatterns) {
            this.includedPatterns = includedPatterns;
        }

        public String[] getExcludedPatterns() {
            return excludedPatterns;
        }

        public void setExcludedPatterns(String[] excludedPatterns) {
            this.excludedPatterns = excludedPatterns;
        }
    }
}
