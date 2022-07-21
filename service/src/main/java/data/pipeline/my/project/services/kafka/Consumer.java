package data.pipeline.my.project.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "t.food.order")
    public void consumeMessage(String message) throws JsonProcessingException {
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println(message);
        System.out.println("------------------------------");
        System.out.println("------------------------------");
    }
}
