package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BaseCommonConstants;
import com.dct.model.constants.BasePropertiesConstants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
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
@ConfigurationProperties(prefix = BasePropertiesConstants.SOCKET_CONFIG)
public class SocketProps {
    private ActivateStatus activate = ActivateStatus.DISABLED;
    private String[] allowedOriginPatterns;
    private String[] brokerPrefixes;
    private String[] applicationPrefixes;
    private String[] endpoints;
    private List<Class<?>> interceptors;
    private Class<?> handshakeHandler;
    private Long serverHeartbeatInterval;
    private Long clientHeartbeatInterval;

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public String[] getBrokerPrefixes() {
        return Optional.ofNullable(brokerPrefixes).orElse(BaseCommonConstants.Socket.DEFAULT_BROKER_PREFIXES);
    }

    public void setBrokerPrefixes(String[] brokerPrefixes) {
        this.brokerPrefixes = brokerPrefixes;
    }

    public String[] getApplicationPrefixes() {
        return Optional.ofNullable(applicationPrefixes).orElse(BaseCommonConstants.Socket.DEFAULT_APPLICATION_PREFIXES);
    }

    public void setApplicationPrefixes(String[] applicationPrefixes) {
        this.applicationPrefixes = applicationPrefixes;
    }

    public String[] getEndpoints() {
        return Optional.ofNullable(endpoints).orElse(BaseCommonConstants.Socket.DEFAULT_ENDPOINTS);
    }

    public void setEndpoints(String[] endpoints) {
        this.endpoints = endpoints;
    }

    public String[] getAllowedOriginPatterns() {
        return allowedOriginPatterns;
    }

    public void setAllowedOriginPatterns(String[] allowedOriginPatterns) {
        this.allowedOriginPatterns = allowedOriginPatterns;
    }

    public List<Class<?>> getInterceptors() {
        return Optional.ofNullable(this.interceptors).orElseGet(ArrayList::new);
    }

    public void setInterceptors(List<Class<?>> interceptors) {
        this.interceptors = interceptors;
    }

    public Class<?> getHandshakeHandler() {
        return handshakeHandler;
    }

    public void setHandshakeHandler(Class<?> handshakeHandler) {
        this.handshakeHandler = handshakeHandler;
    }

    public Long getServerHeartbeatInterval() {
        return Optional.ofNullable(serverHeartbeatInterval)
                .orElse(BaseCommonConstants.Socket.DEFAULT_SERVER_HEARTBEAT_INTERVAL);
    }

    public void setServerHeartbeatInterval(Long serverHeartbeatInterval) {
        this.serverHeartbeatInterval = serverHeartbeatInterval;
    }

    public Long getClientHeartbeatInterval() {
        return Optional.ofNullable(clientHeartbeatInterval)
                .orElse(BaseCommonConstants.Socket.DEFAULT_SERVER_HEARTBEAT_INTERVAL);
    }

    public void setClientHeartbeatInterval(Long clientHeartbeatInterval) {
        this.clientHeartbeatInterval = clientHeartbeatInterval;
    }
}
