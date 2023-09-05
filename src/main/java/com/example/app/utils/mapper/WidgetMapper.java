package com.example.app.utils.mapper;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.WidgetResponseDTO;
import com.example.app.model.WidgetEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses = {TopicMapper.class})
public interface WidgetMapper {

    WidgetResponseDTO toWidgetResponse(WidgetEntity entity);

    WidgetEntity toWidgetEntity(WidgetRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateWidgetEntity(@MappingTarget WidgetEntity entity, WidgetRequestDTO request);

    List<WidgetResponseDTO> toWidgetResponseList(Collection<WidgetEntity> entities);
}
