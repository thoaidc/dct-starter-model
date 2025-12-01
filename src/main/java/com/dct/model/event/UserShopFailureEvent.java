package com.dct.model.event;

@SuppressWarnings("unused")
public class UserShopFailureEvent {
    private String sagaId;
    private String userId;
    private String errorMessage;
    private String errorCode;

    public UserShopFailureEvent(String sagaId, String userId, String errorMessage, String errorCode) {
        this.sagaId = sagaId;
        this.userId = userId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String sagaId;
        private String userId;
        private String errorMessage;
        private String errorCode;

        public Builder sagaId(String sagaId) {
            this.sagaId = sagaId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public UserShopFailureEvent build() {
            return new UserShopFailureEvent(sagaId, userId, errorMessage, errorCode);
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
