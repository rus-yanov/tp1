package com.example.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageRequestDTO {

    private String name;

    private String description;

    private Long authorId;

    private Set<Long> categoryIds;

    private Set<Long> widgetIds;
}
