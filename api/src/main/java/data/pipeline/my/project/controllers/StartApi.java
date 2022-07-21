package data.pipeline.my.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public interface StartApi {

    @GetMapping(path="/start")
    Mono<String> start() throws JsonProcessingException;
}
