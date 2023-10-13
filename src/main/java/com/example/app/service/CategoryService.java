package com.example.app.service;

import com.example.app.dto.request.CategoryRequestDTO;
import com.example.app.dto.response.CategoryResponseDTO;
import com.example.app.dto.response.PageOfListResponse;

import java.util.UUID;

public interface CategoryService {

    CategoryResponseDTO create(CategoryRequestDTO categoryDTO);

    CategoryResponseDTO getById(UUID id);

    PageOfListResponse<CategoryResponseDTO> getAll(int page, int size);

    CategoryResponseDTO update(CategoryRequestDTO categoryDTO, UUID id);

    void delete(UUID id);
}
