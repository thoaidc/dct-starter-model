package com.dct.model.event;

@SuppressWarnings("unused")
public class UserCreatedEvent {
    private String sagaId;
    private Integer userId;
    private String email;
    private String phone;
    private String shopName;

    public UserCreatedEvent() {}

    public UserCreatedEvent(
        String sagaId,
        Integer userId,
        String email,
        String phone,
        String shopName
    ) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.shopName = shopName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String sagaId;
        private Integer userId;
        private String email;
        private String phone;
        private String shopName;

        public Builder sagaId(String sagaId) {
            this.sagaId = sagaId;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder shopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public UserCreatedEvent build() {
            return new UserCreatedEvent(sagaId, userId, email, phone, shopName);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return String.format("sagaId: %s, userId: %s, shopName: %s", sagaId, userId, shopName);
    }
}
