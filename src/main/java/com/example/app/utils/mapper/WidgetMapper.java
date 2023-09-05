package com.example.app.utils.mapper;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.WidgetResponseDTO;
import com.example.app.model.Widget;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses = {PageMapper.class})
public interface WidgetMapper {

    WidgetResponseDTO toWidgetResponse(Widget entity);

    Widget toWidgetEntity(WidgetRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateWidgetEntity(@MappingTarget Widget entity, WidgetRequestDTO request);
}
