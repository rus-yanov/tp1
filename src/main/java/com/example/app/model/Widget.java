package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "widgets")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "widgets")
    private List<Page> pages;

}
