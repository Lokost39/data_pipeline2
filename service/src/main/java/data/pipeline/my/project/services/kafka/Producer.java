package data.pipeline.my.project.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public Mono<String> sendMessage(String foodOrder) {

        return Mono.just(foodOrder)
                .flatMap(this::writeValueAsString)
                .flatMap(o -> Mono.just(kafkaTemplate.send(orderTopic, o)))
                .flatMap(o -> {
                    System.out.println("+++++++++++++++++++++++++++++++");
                    System.out.println("+++++++++++++++++++++++++++++++");
                    System.out.println("food order produced");
                    System.out.println("+++++++++++++++++++++++++++++++");
                    System.out.println("+++++++++++++++++++++++++++++++");
                    return Mono.just("send message");
                })
        ;
    }

    private Mono<String> writeValueAsString(String foodOrder) {
        try {
            return Mono.just(objectMapper.writeValueAsString(foodOrder));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
