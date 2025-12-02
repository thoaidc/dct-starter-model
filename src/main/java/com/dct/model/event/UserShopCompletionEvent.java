package com.dct.model.event;

@SuppressWarnings("unused")
public class UserShopCompletionEvent {
    private String sagaId;
    private Integer userId;
    private Integer shopId;
    private String shopName;

    public UserShopCompletionEvent() {}

    public UserShopCompletionEvent(String sagaId, Integer userId, Integer shopId, String shopName) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.shopId = shopId;
        this.shopName = shopName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String sagaId;
        private Integer userId;
        private Integer shopId;
        private String shopName;

        public Builder sagaId(String sagaId) {
            this.sagaId = sagaId;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder shopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }

        public Builder shopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public UserShopCompletionEvent build() {
            return new UserShopCompletionEvent(sagaId, userId, shopId, shopName);
        }
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return String.format("sagaId: %s, userId: %s, shopId: %s, shopName: %s", sagaId, userId, shopId, shopName);
    }
}
