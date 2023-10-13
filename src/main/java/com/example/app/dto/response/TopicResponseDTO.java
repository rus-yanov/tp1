package com.example.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TopicResponseDTO {

    private UUID id;

    private String name;

    private String content;

    private Set<Long> categoryIds;

    private Set<Long> widgetIds;
}
