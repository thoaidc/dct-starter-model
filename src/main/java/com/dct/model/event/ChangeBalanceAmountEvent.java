package com.dct.model.event;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class ChangeBalanceAmountEvent {
    private String description;
    private Integer type;
    private Integer refId;
    private BigDecimal amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "type=" + type + ", refId=" + refId + ", amount=" + amount;
    }
}
