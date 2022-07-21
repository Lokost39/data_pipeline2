package data.pipeline.my.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import data.pipeline.my.project.services.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class Start implements StartApi {

//    @Autowired
//    KafkaTemplate kafkaTemplate;
    @Autowired
    Producer producer;

    public Mono<String> start() throws JsonProcessingException {
        producer.sendMessage(UUID.randomUUID().toString());
        return Mono.just(UUID.randomUUID().toString());
    }
}
