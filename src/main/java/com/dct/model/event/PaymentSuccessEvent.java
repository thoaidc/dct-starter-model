package com.dct.model.event;

@SuppressWarnings("unused")
public class PaymentSuccessEvent {
    private String sagaId;
    private Integer userId;
    private Integer orderId;

    public PaymentSuccessEvent() {}

    public PaymentSuccessEvent(String sagaId, Integer userId, Integer orderId) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.orderId = orderId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
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
