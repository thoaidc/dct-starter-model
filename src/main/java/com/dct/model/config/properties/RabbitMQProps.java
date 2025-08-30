package com.dct.model.config.properties;

import com.dct.model.constants.ActivateStatus;
import com.dct.model.constants.BasePropertiesConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * When the application starts, Spring will automatically create an instance of this class
 * and load the values from configuration files like application.properties or application.yml <p>
 *
 * {@link ConfigurationProperties} helps Spring map config properties to fields,
 * instead of using @{@link Value} for each property individually <p>
 *
 * {@link BasePropertiesConstants#RABBIT_MQ_CONFIG} decides the prefix for the configurations that will be mapped <p>
 *
 * See <a href="">application-dev.yml</a> for detail
 *
 * @author thoaidc
 */
@SuppressWarnings({"ConfigurationProperties", "unused"})
@ConfigurationProperties(prefix = BasePropertiesConstants.RABBIT_MQ_CONFIG)
public class RabbitMQProps {
    private ActivateStatus activate;
    private String[] servers;
    private int port;
    private String virtualHost;
    private String username;
    private String password;
    private Exchange exchange;
    private Map<String, Queue> queues;
    private Consumer consumer;
    private Producer producer;

    public ActivateStatus getActivate() {
        return activate;
    }

    public void setActivate(ActivateStatus activate) {
        this.activate = activate;
    }

    public String[] getServers() {
        return servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public Map<String, Queue> getQueues() {
        return queues;
    }

    public void setQueues(Map<String, Queue> queues) {
        this.queues = queues;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public static class Exchange {
        private String direct;
        private String topic;
        private String fanout;

        public String getDirect() {
            return direct;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getFanout() {
            return fanout;
        }

        public void setFanout(String fanout) {
            this.fanout = fanout;
        }
    }

    public static class Queue {
        private String name;
        private String routingKey;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRoutingKey() {
            return routingKey;
        }

        public void setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
        }
    }

    public static class Consumer {
        private int maxConcurrentConsumer;
        private int concurrentConsumer;
        private int prefetchCount;

        public int getMaxConcurrentConsumer() {
            return maxConcurrentConsumer;
        }

        public void setMaxConcurrentConsumer(int maxConcurrentConsumer) {
            this.maxConcurrentConsumer = maxConcurrentConsumer;
        }

        public int getConcurrentConsumer() {
            return concurrentConsumer;
        }

        public void setConcurrentConsumer(int concurrentConsumer) {
            this.concurrentConsumer = concurrentConsumer;
        }

        public int getPrefetchCount() {
            return prefetchCount;
        }

        public void setPrefetchCount(int prefetchCount) {
            this.prefetchCount = prefetchCount;
        }
    }

    public static class Producer {
        private long replyTimeout;

        public long getReplyTimeout() {
            return replyTimeout;
        }

        public void setReplyTimeout(long replyTimeout) {
            this.replyTimeout = replyTimeout;
        }
    }
}
