package com.example.app.repository;

import com.example.app.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findFirstByOrderById();
}
