package com.dct.model.event;

@SuppressWarnings("unused")
public class UserShopCompletionEvent {
    private String sagaId;
    private String userId;
    private String shopId;
    private String shopName;

    public UserShopCompletionEvent(String sagaId, String userId, String shopId, String shopName) {
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
        private String userId;
        private String shopId;
        private String shopName;

        public Builder sagaId(String sagaId) {
            this.sagaId = sagaId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder shopId(String shopId) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
