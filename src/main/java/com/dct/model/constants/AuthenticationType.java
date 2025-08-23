package com.dct.model.constants;

@SuppressWarnings("unused")
public enum AuthenticationType {
    JWT_VERIFY,
    MIX_JWT_OAUTH2,
    HEADER_FORWARDED,
    CUSTOM;

    public final static String JWT_VERIFY_VALUE = "JWT_VERIFY";
    public final static String MIX_JWT_OAUTH2_VALUE = "MIX_JWT_OAUTH2";
    public final static String HEADER_FORWARDED_VALUE = "HEADER_FORWARDED";
    public final static String CUSTOM_VALUE = "CUSTOM";
}
