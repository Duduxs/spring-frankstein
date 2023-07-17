package com.edudev.mongowebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloResource {


    @GetMapping
    public Mono<String> sayHello() {
        return Mono.just("Hello");
    }

}
