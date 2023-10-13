package com.example.app.dto.response;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;

}
