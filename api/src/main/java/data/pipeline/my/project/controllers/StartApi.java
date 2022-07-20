package data.pipeline.my.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public interface StartApi {

    @GetMapping(path="/start")
    Mono<String> start();
}
