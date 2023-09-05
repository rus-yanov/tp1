package com.example.app.dto.response;

import com.example.app.model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank (message = "Firstname is mandatory")
    private String firstName;

    @NotBlank (message = "Lastname is mandatory")
    private String lastName;

    @NotBlank
    private Role role;
}
