package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Getter
@Setter
@Table(name = "widgets")
@NoArgsConstructor
@AllArgsConstructor
public class Widget {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotBlank (message = "Name is mandatory")
    @Column(unique = true)
    private String name;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "widgets")
    private List<Page> pages;

    public Page(final Long id) {
        this.id = id;
    }
}
