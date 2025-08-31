package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseUserConstants {
    interface Status {
        Short INACTIVE = 0;
        Short ACTIVE = 1;
        Short LOCKED = 2;
        Short DELETED = 3;
    }
}
