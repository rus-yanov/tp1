package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class CategoryEntity extends AbstractEntity {

    @NotBlank
    @Column(name = "name",
            unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "categories")
    private List<TopicEntity> topics;

}
