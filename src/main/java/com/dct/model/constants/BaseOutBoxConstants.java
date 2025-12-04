package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseOutBoxConstants {
    interface Type {
        String REGISTER_USER_WITH_SHOP_COMPLETION = "REGISTER_USER_WITH_SHOP_COMPLETION";
        String REGISTER_USER_WITH_SHOP_FAILURE = "REGISTER_USER_WITH_SHOP_FAILURE";
        String ORDER_PAYMENT_FAILURE = "ORDER_PAYMENT_FAILURE";
        String ORDER_PAYMENT_SUCCESSFULLY = "ORDER_PAYMENT_SUCCESSFULLY";
    }

    interface Status {
        String PENDING = "PENDING";
        String COMPLETION = "COMPLETION";
    }

    int DELAY_TIME = 5000; // 5 seconds
}
