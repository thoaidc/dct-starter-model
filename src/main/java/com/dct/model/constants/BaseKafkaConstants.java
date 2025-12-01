package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseKafkaConstants {
    interface Topic {
        String CREATE_USER_SHOP_COMPLETION = "${spring.kafka.topics.create-user-shop-completion}";
        String CREATE_USER_SHOP_FAILURE = "${spring.kafka.topics.create-user-shop-failure}";
        String REGISTER_SHOP = "${spring.kafka.topics.register-shop}";
    }

    interface GroupId {
        String CREATE_USER_SHOP_COMPLETION = "create-user-shop-completion-group-id";
        String CREATE_USER_SHOP_FAILURE = "create-user-shop-failure-group-id";
        String REGISTER_SHOP = "register-shop-group-id";
    }

    interface Consumers {
        String CREATE_USER_SHOP_COMPLETION = "1"; // Number of consumers processing message concurrent
        String CREATE_USER_SHOP_FAILURE = "1"; // Number of consumers processing message concurrent
        String REGISTER_SHOP = "1"; // Number of consumers processing message concurrent
    }
}
