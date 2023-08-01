package com.edudev.grpc.repositories;

import com.edudev.grpc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
