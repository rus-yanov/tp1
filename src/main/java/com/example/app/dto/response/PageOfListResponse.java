package com.example.app.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "List with pagination")
public class PageOfListResponse<T> {

    @Schema(description = "The list")
    private List<T> elements;

    @Schema(description = "Number of pages", example = "1")
    @JsonProperty("total_page")
    private int totalPage;

    @Schema(description = "The page's size", example = "1")
    private int size;
}
