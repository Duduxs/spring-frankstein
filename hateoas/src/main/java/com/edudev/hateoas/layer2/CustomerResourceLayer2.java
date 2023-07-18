package com.edudev.hateoas.layer2;

import com.edudev.hateoas.entities.Customer;
import com.edudev.hateoas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("camada2")
public class CustomerResourceLayer2 {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public ResponseEntity<Collection<Customer>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.status(201).body(repository.save(customer));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Customer customer) {
        var data = repository.findById(id);
        if (data.isPresent()) {
            customer.id = data.get().id;
            repository.save(customer);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.findById(id).ifPresent(customer -> repository.delete(customer));
        return ResponseEntity.notFound().build();
    }
}
