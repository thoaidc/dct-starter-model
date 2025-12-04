package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseOutBoxConstants {
    interface Type {
        String USER_CREATED = "USER_CREATED";
        String USER_REGISTER_SHOP_COMPLETION = "USER_REGISTER_SHOP_COMPLETION";
        String USER_REGISTER_SHOP_FAILURE = "USER_REGISTER_SHOP_FAILURE";
        String ORDER_CREATED = "ORDER_CREATED";
        String ORDER_PAYMENT_FAILURE = "ORDER_PAYMENT_FAILURE";
        String ORDER_PAYMENT_SUCCESSFUL = "ORDER_PAYMENT_SUCCESSFUL";
    }

    interface Status {
        String PENDING = "PENDING";
        String COMPLETION = "COMPLETION";
    }

    int DELAY_TIME = 5000; // 5 seconds
}
