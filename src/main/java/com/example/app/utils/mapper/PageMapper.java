package com.example.app.utils.mapper;

import com.example.app.dto.request.PageRequestDTO;
import com.example.app.dto.response.PageResponseDTO;
import com.example.app.model.Page;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface PageMapper {

    PageResponseDTO toPageResponse(Page entity);

    Page toPageEntity(PageRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updatePageEntity(@MappingTarget Page entity, PageRequestDTO request);

}
