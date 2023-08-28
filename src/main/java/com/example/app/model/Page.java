package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.TIMESTAMP;
import static org.hibernate.annotations.FetchMode.JOIN;

@Entity
@Getter
@Setter
@Table(name = "pages")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Page {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    @NotBlank (message = "Name is mandatory")
    private String name;

    private String description;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @ManyToMany
    @Fetch(JOIN)
    private Set<Category> categories;

    @ManyToMany
    @Fetch(JOIN)
    private Set<Widget> widgets;
}
