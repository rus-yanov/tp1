package com.example.app.service.impl;

import com.example.app.dto.request.CategoryRequestDTO;
import com.example.app.dto.response.CategoryResponseDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.model.CategoryEntity;
import com.example.app.repository.CategoryRepository;
import com.example.app.service.CategoryService;
import com.example.app.utils.exception.ApplicationNotFoundException;
import com.example.app.utils.mapper.CategoryMapper;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO categoryRequest) {

        log.info("#create: Create category, category name - {}", categoryRequest.getName());
        CategoryEntity newCategory = categoryRepository.save(categoryMapper
                        .toCategoryEntity(categoryRequest));
        return categoryMapper.toCategoryResponse(newCategory);
    }

    @Override
    public CategoryResponseDTO getById(UUID id) {

        log.info("#getById: Get category by id, id - {}", id);
        CategoryEntity category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "Category not found, category-id - " + id));

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public PageOfListResponse<CategoryResponseDTO> getAll(int page, int size) {

        log.info("#getAll: Get all categories, page - {}, size - {}", page, size);
        Page<CategoryEntity> pageOfCategories = categoryRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<CategoryResponseDTO>builder()
                .elements(categoryMapper.toCategoryResponseList(pageOfCategories.getContent()))
                .size(size)
                .totalPage(pageOfCategories.getTotalPages())
                .build();
    }

    @Override
    public CategoryResponseDTO update(CategoryRequestDTO categoryRequest, UUID id) {

        log.info("#update: Update category, id - {}", id);
        CategoryEntity categoryToUpdate = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "Category not found, category-id - " + id));

        categoryMapper.updateCategoryEntity(categoryToUpdate, categoryRequest);
        return categoryMapper.toCategoryResponse(categoryToUpdate);
    }

    @Override
    public void delete(UUID id) {

        log.info("#delete: Delete category by id, id - {}", id);
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "Category not found, category-id - " + id);
        }
    }
}
