package com.raj.service;

import com.raj.dto.Customer;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisherService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaMessagePublisherService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToTopic(String message) {
      CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("springboot-topic1", message);
      future.whenComplete((result, ex) -> {
          if (ex == null) {
             System.out.println("Send Message -> "+message+" Offset-> "+result.getRecordMetadata().offset());
          }else{
              System.out.println("Unaable to send message "+ex.getMessage());
          }
      });
    }

    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("springboot-events-demo", 2,null, customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Send Message -> " + customer.toString() + " Offset-> " + result.getRecordMetadata().offset());
                } else {
                    System.out.println("Unaable to send message " +ex.getMessage() );
                    ex.printStackTrace();
                }
            });
        }catch (Exception e){
            System.out.println("Unable to send message "+e.getMessage());
            e.printStackTrace();
        }
    }
}
