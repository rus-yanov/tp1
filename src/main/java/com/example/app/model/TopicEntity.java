package com.example.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "topics")
public class TopicEntity extends AbstractEntity {

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<CategoryEntity> categories;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<WidgetEntity> widgets;

}
