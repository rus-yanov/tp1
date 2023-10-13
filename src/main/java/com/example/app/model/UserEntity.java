package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Email
    @Column(name = "email",
            unique = true)
    private String email;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @NotBlank
    @JsonIgnore
    @Column(name = "password")
    private byte[] password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users")
//    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private List<TopicEntity> topics;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users")
    private Set<CategoryEntity> categories;
}
