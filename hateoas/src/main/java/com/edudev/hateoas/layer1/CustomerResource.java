package com.edudev.hateoas.layer1;

import com.edudev.hateoas.entities.Customer;
import com.edudev.hateoas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

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
