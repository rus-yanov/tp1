package com.example.app.utils.mapper;

import com.example.app.dto.request.CategoryRequestDTO;
import com.example.app.dto.response.CategoryResponseDTO;
import com.example.app.model.CategoryEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO toCategoryResponse(CategoryEntity entity);

    CategoryEntity toCategoryEntity(CategoryRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateCategoryEntity(@MappingTarget CategoryEntity entity, CategoryRequestDTO request);

    List<CategoryResponseDTO> toCategoryResponseList(Collection<CategoryEntity> entities);
}
