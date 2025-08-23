package com.dct.model.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BasePropertiesConstants;

/**
 * Contains configuration properties related to Circuit Breaker time limiter config<p>
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#CIRCUIT_BREAKER_TIME_LIMITER_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-test.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.CIRCUIT_BREAKER_TIME_LIMITER_CONFIG)
public class Resilience4jTimeLimiterProps {

    private ActivateStatus activate;
    private long overallTimeout;
    private boolean cancelRunningFuture;

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public long getOverallTimeout() {
        return overallTimeout;
    }

    public void setOverallTimeout(long overallTimeout) {
        this.overallTimeout = overallTimeout;
    }

    public boolean isCancelRunningFuture() {
        return cancelRunningFuture;
    }

    public void setCancelRunningFuture(boolean cancelRunningFuture) {
        this.cancelRunningFuture = cancelRunningFuture;
    }
}
