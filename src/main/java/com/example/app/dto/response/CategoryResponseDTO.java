package com.example.app.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryResponseDTO {

    private UUID id;

    private String name;
}
