package com.edudev.mongowebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    CustomerRepository repository;

    @GetMapping
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        return repository.save(customer);
    }

}
