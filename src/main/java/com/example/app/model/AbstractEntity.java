package com.example.app.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
}