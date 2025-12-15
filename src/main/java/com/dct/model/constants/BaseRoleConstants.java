package com.dct.model.constants;

/**
 * Please do not delete fields that are considered unused <p>
 * As it is used to reference the database permission list config for comparison <p>
 * Used in this application with @CheckAuthorize
 *
 * @author thoaidc
 */
@SuppressWarnings("unused")
public interface BaseRoleConstants {
    String ADMIN = "00";

    interface System {
        String SYSTEM = "01";
        String UPDATE = "0102";
    }

    interface User {
        String USER = "02";
        String CREATE = "0201";
        String UPDATE = "0202";
        String DELETE = "0203";
    }

    interface Role {
        String ROLE = "03";
        String CREATE = "0301";
        String UPDATE = "0302";
        String DELETE = "0303";
    }
}
