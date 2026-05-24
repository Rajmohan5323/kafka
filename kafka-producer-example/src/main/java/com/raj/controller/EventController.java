package com.raj.controller;



import com.raj.dto.Customer;
import com.raj.service.KafkaMessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {
    @Autowired
    private KafkaMessagePublisherService kafkaMessagePublisherService;

    @GetMapping("/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            for(int i = 0; i < 10000; i++) {
                kafkaMessagePublisherService.sendMessageToTopic(message+" "+i);
            }
            return ResponseEntity.ok("Message published successfully...");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

 /*   @PostMapping("/publish")
    public void sentEvents(@RequestBody Customer customer){
        kafkaMessagePublisherService.sendEventsToTopic(customer);
    }*/

    @PostMapping("/publish")
    public ResponseEntity<String> sentEvents(@RequestBody Customer customer){
        kafkaMessagePublisherService.sendEventsToTopic(customer);
        return ResponseEntity.ok("Event published");
    }
}
