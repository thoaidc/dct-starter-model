package com.dct.model.constants;

import com.dct.model.exception.BaseIllegalArgumentException;

@SuppressWarnings("unused")
public interface BaseUserConstants {
    String ENTITY_NAME = "com.dct.model.constants.BaseUserConstants";

    interface Status {
        byte INACTIVE = 0;
        byte ACTIVE = 1;
        byte LOCKED = 2;
        byte DELETED = 3;

        static String toString(byte status) {
            return switch (status) {
                case INACTIVE -> "INACTIVE";
                case ACTIVE -> "ACTIVE";
                case LOCKED -> "LOCKED";
                case DELETED -> "DELETED";
                default -> throw new BaseIllegalArgumentException(ENTITY_NAME, "Unexpected user status: " + status);
            };
        }
    }
}
