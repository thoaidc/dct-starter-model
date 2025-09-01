package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseUserConstants {
    interface Status {
        byte INACTIVE = 0;
        byte ACTIVE = 1;
        byte LOCKED = 2;
        byte DELETED = 3;
    }
}
