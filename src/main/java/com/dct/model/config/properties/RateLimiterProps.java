package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BasePropertiesConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#RATE_LIMIT_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-dev.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.RATE_LIMIT_CONFIG)
public class RateLimiterProps {
    private ActivateStatus activate = ActivateStatus.DISABLED;
    private boolean ipValidationEnabled = true;
    private List<String> excludedIps;
    private List<String> excludedIpPrefixes;

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public boolean isIpValidationEnabled() {
        return ipValidationEnabled;
    }

    public void setIpValidationEnabled(boolean ipValidationEnabled) {
        this.ipValidationEnabled = ipValidationEnabled;
    }

    public List<String> getExcludedIps() {
        return excludedIps;
    }

    public void setExcludedIps(List<String> excludedIps) {
        this.excludedIps = excludedIps;
    }

    public List<String> getExcludedIpPrefixes() {
        return excludedIpPrefixes;
    }

    public void setExcludedIpPrefixes(List<String> excludedIpPrefixes) {
        this.excludedIpPrefixes = excludedIpPrefixes;
    }
}
