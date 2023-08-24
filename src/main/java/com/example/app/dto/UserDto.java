package com.example.app.dto;

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
public class UserDto {

//    private long id;

    @NotBlank (message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank (message = "Firstname is mandatory")
    private String firstName;

    @NotBlank (message = "Lastname is mandatory")
    private String lastName;

    @NotBlank (message = "Password is mandatory")
    private String password;

}
