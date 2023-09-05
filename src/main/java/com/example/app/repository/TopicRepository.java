package com.example.app.repository;

import com.example.app.model.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    Optional<TopicEntity> findFirstByOrderById();

}
