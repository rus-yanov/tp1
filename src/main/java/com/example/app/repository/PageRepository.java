package com.example.app.repository;

import com.example.app.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    Optional<Page> findById(Long id);
    Optional<Page> findFirstByOrderById();
    List<Page> findAll();
}
