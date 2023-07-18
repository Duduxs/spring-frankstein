package com.edudev.hateoas.repositories;

import com.edudev.hateoas.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
