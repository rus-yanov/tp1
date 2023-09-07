package com.example.app.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
