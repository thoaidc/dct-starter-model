package com.dct.model.constants;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface BasePaymentConstants {

    /**
     * System revenue = CUSTOMER_PAY_ORDER - SYSTEM_REFUND_CUSTOMER
     * System profit = SYSTEM_COLLECT_FEE
     * Shop revenue = SYSTEM_PAY_SHOP
     * Shop profit = SYSTEM_PAY_SHOP - SYSTEM_COLLECT_FEE
     */
    interface PaymentType {
        int CUSTOMER_PAY_ORDER = 1;     // Customer -> System
        int SYSTEM_PAY_SHOP = 2;        // System -> Shop
        int SYSTEM_COLLECT_FEE = 3;     // Shop -> System
        int SYSTEM_REFUND_CUSTOMER = 4; // System -> Customer
    }

    interface BalanceType {
        int SYSTEM = 1;
        int SHOP = 2;
    }

    BigDecimal PLATFORM_FEE_FACTOR = new BigDecimal("0.05"); // 5% order total amount
    int SCALE_NUMBER = 0; // Round to zero decimal places
    int SYSTEM_ACCOUNT_ID = 0;
}
