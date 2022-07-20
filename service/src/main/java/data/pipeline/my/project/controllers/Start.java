package data.pipeline.my.project.controllers;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class Start implements StartApi {

    public Mono<String> start(){
        return Mono.just(UUID.randomUUID().toString());
    }
}
