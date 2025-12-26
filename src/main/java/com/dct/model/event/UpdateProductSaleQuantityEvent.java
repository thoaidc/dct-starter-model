package com.dct.model.event;

public class UpdateProductSaleQuantityEvent {
    private Integer productId;
    private int amount;

    public UpdateProductSaleQuantityEvent() {}

    public UpdateProductSaleQuantityEvent(Integer productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
