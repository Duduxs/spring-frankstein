package com.edudev.hateoas.layer3;

import com.edudev.hateoas.entities.Customer;
import com.edudev.hateoas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("customers")
public class CustomerResourceLayer3 {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public ResponseEntity<Collection<EntityModel<Customer>>> findAll() {
        var result = repository.findAll()
                .stream()
                .map(entity -> EntityModel.of(entity).add(
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerResourceLayer3.class).findById(entity.id)).withSelfRel()
                )).toList();

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<Customer>> findById(@PathVariable Long id) {
        var result = repository.findById(id)
                .map(entity -> EntityModel.of(entity)
                        .add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerResourceLayer3.class).findAll()).withRel("Find All Customers"))
                );

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<EntityModel<Customer>> create(@RequestBody Customer customer) {
        var created = repository.save(customer);

        var em = EntityModel.of(created).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerResourceLayer3.class).findById(created.id)).withSelfRel());
        return ResponseEntity.status(201).body(em);
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
