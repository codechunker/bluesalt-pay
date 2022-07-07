package com.bluesalt.bluesaltpay.shareddto.config;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//@Configuration
//@ConfigurationProperties("bluesalt.kafka")
//@Data
public class KafkaConfig {
    private int partitions;
    private int replicas;
    private String topicName;

//    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(topicName)
                .partitions(partitions)
                .replicas(replicas)
                .compact()
                .build();
    }
}
