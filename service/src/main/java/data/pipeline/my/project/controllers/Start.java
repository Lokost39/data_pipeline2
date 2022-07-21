package data.pipeline.my.project.controllers;

import data.pipeline.my.project.services.kafka.SendMessageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
public class Start implements StartApi {
    @Autowired
    private SendMessageTask sendMessageTask;

    public Mono<String> start(){
        try {
            sendMessageTask.send();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just(UUID.randomUUID().toString());
    }
}
