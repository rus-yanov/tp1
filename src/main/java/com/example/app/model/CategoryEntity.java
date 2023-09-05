package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "categories")
public class CategoryEntity extends AbstractEntity {

    @NotBlank
    @Column(name = "name",
            unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "categories")

    private Set<TopicEntity> topics;

}
