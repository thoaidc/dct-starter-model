package com.dct.model.config.properties;

import com.dct.model.constants.BasePropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.KAFKA_CONFIG)
public class KafkaProperties {
    private Topic topics;

    public Topic getTopics() {
        return topics;
    }

    public void setTopics(Topic topics) {
        this.topics = topics;
    }

    public static class Topic {
        private String userCreated;
        private String userRegisterShopCompletion;
        private String userRegisterShopFailure;
        private String orderCreated;
        private String orderPaymentSuccessful;
        private String orderPaymentFailure;
        private String changeBalanceAmount;
        private String updateProductSaleQuantity;

        public String getUserCreated() {
            return userCreated;
        }

        public void setUserCreated(String userCreated) {
            this.userCreated = userCreated;
        }

        public String getUserRegisterShopCompletion() {
            return userRegisterShopCompletion;
        }

        public void setUserRegisterShopCompletion(String userRegisterShopCompletion) {
            this.userRegisterShopCompletion = userRegisterShopCompletion;
        }

        public String getUserRegisterShopFailure() {
            return userRegisterShopFailure;
        }

        public void setUserRegisterShopFailure(String userRegisterShopFailure) {
            this.userRegisterShopFailure = userRegisterShopFailure;
        }

        public String getOrderCreated() {
            return orderCreated;
        }

        public void setOrderCreated(String orderCreated) {
            this.orderCreated = orderCreated;
        }

        public String getOrderPaymentSuccessful() {
            return orderPaymentSuccessful;
        }

        public void setOrderPaymentSuccessful(String orderPaymentSuccessful) {
            this.orderPaymentSuccessful = orderPaymentSuccessful;
        }

        public String getOrderPaymentFailure() {
            return orderPaymentFailure;
        }

        public void setOrderPaymentFailure(String orderPaymentFailure) {
            this.orderPaymentFailure = orderPaymentFailure;
        }

        public String getChangeBalanceAmount() {
            return changeBalanceAmount;
        }

        public void setChangeBalanceAmount(String changeBalanceAmount) {
            this.changeBalanceAmount = changeBalanceAmount;
        }

        public String getUpdateProductSaleQuantity() {
            return updateProductSaleQuantity;
        }

        public void setUpdateProductSaleQuantity(String updateProductSaleQuantity) {
            this.updateProductSaleQuantity = updateProductSaleQuantity;
        }
    }
}
