package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Email
    @Column(name = "email",
            unique = true)
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @JsonIgnore
    @Column(name = "password")
    private byte[] password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users")
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private List<TopicEntity> listOfTopics;
}
