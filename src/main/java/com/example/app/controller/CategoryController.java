package com.example.app.controller;

import com.example.app.dto.request.CategoryRequestDTO;
import com.example.app.dto.response.CategoryResponseDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.model.CategoryEntity;
import com.example.app.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}/categories/{id}")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Create new category")
    @ApiResponse(responseCode = "201", description = "Category created")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO create(@Valid @RequestBody CategoryRequestDTO categoryDTO) {
        return categoryService.create(categoryDTO);
    }

    @Operation(summary = "Get category by id")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = CategoryEntity.class))))
    @GetMapping("/{id}")
    public CategoryResponseDTO getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = CategoryEntity.class))))
    @GetMapping
    public PageOfListResponse<CategoryResponseDTO> getAll(@RequestParam(value = "page") int page,
                                                          @RequestParam(value = "size") int size) {
        return categoryService.getAll(page, size);
    }

    @Operation(summary = "Update category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category updated"),
            @ApiResponse(responseCode = "404", description = "Category with that id not found")
    })
    @PutMapping("/{id}")
    public CategoryResponseDTO update(@PathVariable Long id,
                                  @Valid @RequestBody CategoryRequestDTO categoryDTO) {
        return categoryService.update(categoryDTO, id);
    }

    @Operation(summary = "Delete category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category deleted"),
            @ApiResponse(responseCode = "404", description = "Category with that id not found")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
