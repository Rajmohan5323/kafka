package com.raj.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListenner {
    Logger log = LoggerFactory.getLogger(KafkaMessageListenner.class);

    @KafkaListener(topics = "springboot-topic1" ,groupId = "cm-group1")
    public void consumer1(String message) {
    log.info("consumer1 consume the message {}",message);
    }

    @KafkaListener(topics = "springboot-topic1" ,groupId = "cm-group1")
    public void consumer2(String message) {
        log.info("consumer2 consume the message {}",message);
    }

    @KafkaListener(topics = "springboot-topic1" ,groupId = "cm-group1")
    public void consumer3(String message) {
        log.info("consumer3 consume the message {}",message);
    }

    @KafkaListener(topics = "springboot-topic1" ,groupId = "cm-group1")
    public void consumer4(String message) {
        log.info("consumer4 consume the message {}",message);
    }


}
