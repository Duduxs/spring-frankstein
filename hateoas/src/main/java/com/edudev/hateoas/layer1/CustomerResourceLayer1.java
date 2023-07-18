package com.edudev.hateoas.layer1;

import com.edudev.hateoas.entities.Customer;
import com.edudev.hateoas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/camada1")
public class CustomerResourceLayer1 {

    @Autowired
    private CustomerRepository repository;

    @PostMapping({"{id}"})
    public Customer show(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }


}
