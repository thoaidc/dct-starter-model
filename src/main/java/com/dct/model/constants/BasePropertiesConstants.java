package com.dct.model.constants;

/**
 * Contains the prefixes for the config property files <p>
 * Refer to these files in the <a href="">com/dct/model/config/properties</a> directory for more details
 *
 * @author thoaidc
 */
@SuppressWarnings("unused")
public interface BasePropertiesConstants {

    String DATASOURCE_CONFIG = "spring.datasource";
    String HIKARI_CONFIG = "spring.datasource.hikari";
    String HIKARI_DATASOURCE_CONFIG = "spring.datasource.hikari.data-source-properties";

    String I18N_CONFIG = "dct.base.i18n";
    String RESOURCE_CONFIG = "dct.base.resources";
    String INTERCEPTOR_CONFIG = "dct.base.interceptor";
    String SECURITY_CONFIG = "dct.base.security";
    String SECURITY_OAUTH2_CONFIG = "dct.base.security.oauth2";
    String SECURITY_JWT_CONFIG = "dct.base.security.jwt";
    String SOCKET_CONFIG = "dct.base.socket";

    String ENABLED_JWT = "dct.base.security.jwt.enabled";
    String ENABLED_OAUTH2 = "dct.base.security.oauth2.enabled";
    String ENABLED_DATASOURCE = "dct.base.features.datasource";
    String ENABLED_AUDITING = "dct.base.features.jpa-auditing";
    String ENABLED_REST_TEMPLATE = "dct.base.features.default-rest-template";
    String ENABLED_RESOURCE = "dct.base.features.resources";
    String ENABLED_SOCKET = "dct.base.features.socket";
    String ENABLED_I18N = "dct.base.features.i18n";
}
