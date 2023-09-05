package com.example.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TopicRequestDTO {

    private String name;

    private String content;

    private Set<Long> categoryIds;

    private Set<Long> widgetIds;
}
