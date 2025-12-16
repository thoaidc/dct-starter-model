package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BasePaymentConstants {
    interface PaymentType {
        int ORDER_PAYMENT = 1;
        int ADD_TO_SHOP_BALANCE = 2;
        int ADD_TO_SYSTEM_FUNDS = 3;
        int REFUND_TO_CUSTOMER = 4;
    }

    interface BalanceType {
        int SYSTEM = 1;
        int SHOP = 2;
    }
}
