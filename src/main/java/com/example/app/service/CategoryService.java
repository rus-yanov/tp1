package com.example.app.service;

import com.example.app.dto.request.CategoryRequestDTO;
import com.example.app.dto.response.CategoryResponseDTO;
import com.example.app.dto.response.PageOfListResponse;

public interface CategoryService {

    CategoryResponseDTO create(CategoryRequestDTO categoryDTO);

    CategoryResponseDTO getById(Long id);

    PageOfListResponse<CategoryResponseDTO> getAll(int page, int size);

    CategoryResponseDTO update(CategoryRequestDTO categoryDTO, Long id);

    void delete(Long id);
}
