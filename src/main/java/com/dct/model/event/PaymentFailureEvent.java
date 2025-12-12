package com.dct.model.event;

@SuppressWarnings("unused")
public class PaymentFailureEvent {
    private Integer userId;
    private Integer orderId;
    private String errorMessage;
    private String errorCode;

    public PaymentFailureEvent() {}

    public PaymentFailureEvent(Integer userId, Integer orderId, String errorMessage, String errorCode) {
        this.userId = userId;
        this.orderId = orderId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
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
