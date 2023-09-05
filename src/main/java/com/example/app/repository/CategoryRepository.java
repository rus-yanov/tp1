package com.example.app.repository;

import com.example.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findFirstByOrderById();
}
