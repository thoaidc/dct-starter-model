package com.dct.model.config.properties;

import com.dct.model.constants.BasePropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.KAFkA_CONFIG)
public class KafkaProperties {
    private Topic topics;

    public Topic getTopics() {
        return topics;
    }

    public void setTopics(Topic topics) {
        this.topics = topics;
    }

    public static class Topic {
        private String createUserShopCompletion;
        private String createUserShopFailure;
        private String registerShop;

        public String getCreateUserShopCompletion() {
            return createUserShopCompletion;
        }

        public void setCreateUserShopCompletion(String createUserShopCompletion) {
            this.createUserShopCompletion = createUserShopCompletion;
        }

        public String getCreateUserShopFailure() {
            return createUserShopFailure;
        }

        public void setCreateUserShopFailure(String createUserShopFailure) {
            this.createUserShopFailure = createUserShopFailure;
        }

        public String getRegisterShop() {
            return registerShop;
        }

        public void setRegisterShop(String registerShop) {
            this.registerShop = registerShop;
        }
    }
}
