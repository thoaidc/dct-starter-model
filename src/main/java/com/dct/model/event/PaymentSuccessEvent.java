package com.dct.model.event;

@SuppressWarnings("unused")
public class PaymentSuccessEvent {
    private Integer userId;
    private Integer orderId;

    public PaymentSuccessEvent() {}

    public PaymentSuccessEvent(Integer userId, Integer orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
