package com.raj.consumer;

import com.raj.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListener {
    Logger log = LoggerFactory.getLogger(KafkaEventListener.class);

    @KafkaListener(groupId = "event-group",
            topicPartitions = {
            @TopicPartition(topic = "springboot-events-demo",partitions = {"2"})})

    public void consumeEvent(Customer customer) {
        log.info("consumer consume the event {}",customer);
    }

}
