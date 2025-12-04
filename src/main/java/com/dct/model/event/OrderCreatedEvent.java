package com.dct.model.event;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class OrderCreatedEvent {
    private String sagaId;
    private Integer userId;
    private Integer orderId;
    private String paymentMethod;
    private BigDecimal amount;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(
        String sagaId,
        Integer userId,
        Integer orderId,
        String paymentMethod,
        BigDecimal amount
    ) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
