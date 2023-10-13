package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "topics")
public class TopicEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<WidgetEntity> widgets;

}
