package com.example.app.dto.request;

import com.example.app.model.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String email;

    private Role role;

    private String firstName;

    private String lastName;
}
