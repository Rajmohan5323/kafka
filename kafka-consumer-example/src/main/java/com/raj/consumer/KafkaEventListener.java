package com.raj.consumer;

import com.raj.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListener {
    Logger log = LoggerFactory.getLogger(KafkaEventListener.class);

    @KafkaListener(topics = "springboot-events-demo",groupId = "event-group")
    public void consumeEvent(Customer customer) {
        log.info("consumer consume the event {}",customer);
    }

}
