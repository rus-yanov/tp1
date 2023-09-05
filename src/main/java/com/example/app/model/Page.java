package com.example.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pages")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    private String name;

    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Category> categories;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Widget> widgets;

}
