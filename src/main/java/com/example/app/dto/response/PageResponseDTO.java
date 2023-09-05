package com.example.app.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Long authorId;

    private Set<Long> categoryIds;

    private Set<Long> widgetIds;
}
