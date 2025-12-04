package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseKafkaConstants {
    interface Topic {
        String USER_CREATED = "${spring.kafka.topics.user-created}";
        String USER_REGISTER_SHOP_COMPLETION = "${spring.kafka.topics.user-register-shop-completion}";
        String USER_REGISTER_SHOP_FAILURE = "${spring.kafka.topics.user-register-shop-failure}";
        String ORDER_CREATED = "${spring.kafka.topics.order-created}";
        String ORDER_PAYMENT_SUCCESSFUL = "${spring.kafka.topics.order-payment-successful}";
        String ORDER_PAYMENT_FAILURE = "${spring.kafka.topics.order-payment-failure}";
    }

    interface GroupId {
        String USER_CREATED = "user-created-group-id";
        String USER_REGISTER_SHOP_COMPLETION = "user-register-shop-completion-group-id";
        String USER_REGISTER_SHOP_FAILURE = "user-register-shop-failure-group-id";
        String ORDER_CREATED = "${spring.kafka.topics.order-created}";
        String ORDER_PAYMENT_SUCCESSFUL = "${spring.kafka.topics.order-payment-successful}";
        String ORDER_PAYMENT_FAILURE = "${spring.kafka.topics.order-payment-failure}";
    }

    // Number of consumers processing message concurrent
    interface Consumers {
        String USER_CREATED = "1";
        String USER_REGISTER_SHOP_COMPLETION = "1";
        String USER_REGISTER_SHOP_FAILURE = "1";
        String ORDER_CREATED = "1";
        String ORDER_PAYMENT_SUCCESSFUL = "1";
        String ORDER_PAYMENT_FAILURE = "1";
    }
}
