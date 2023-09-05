package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "widgets")
public class WidgetEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "widgets")
    private List<TopicEntity> topics;
}
