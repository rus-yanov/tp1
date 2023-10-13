package com.example.app.repository;

import com.example.app.model.WidgetEntity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetRepository extends JpaRepository<WidgetEntity, UUID> {

}
