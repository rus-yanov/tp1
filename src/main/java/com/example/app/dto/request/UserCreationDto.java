package com.example.app.dto.request;

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

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;
}
