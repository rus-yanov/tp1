package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "widgets")
public class WidgetEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "widgets")
    private List<TopicEntity> topics;
}
