package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

import static jakarta.persistence.TemporalType.TIMESTAMP;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotBlank (message = "Name is mandatory")
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Page> pages;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    private Date createdAt;

    public Category(final Long id) {
        this.id = id;
    }
}
