package com.dct.model.constants;

@SuppressWarnings("unused")
public enum AuthenticationType {
    JWT_VERIFY,
    HEADER_FORWARDED,
    CUSTOM;

    public final static String JWT_VERIFY_VALUE = "JWT_VERIFY";
    public final static String HEADER_FORWARDED_VALUE = "HEADER_FORWARDED";
    public final static String CUSTOM_VALUE = "CUSTOM";
}
