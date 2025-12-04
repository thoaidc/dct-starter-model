package com.dct.model.event;

@SuppressWarnings("unused")
public class PaymentFailureEvent {
    private String sagaId;
    private Integer userId;
    private Integer orderId;
    private String errorMessage;
    private String errorCode;

    public PaymentFailureEvent() {}

    public PaymentFailureEvent(String sagaId, Integer userId, Integer orderId, String errorMessage, String errorCode) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.orderId = orderId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
