package com.example.app.utils.mapper;

import com.example.app.dto.request.TopicRequestDTO;
import com.example.app.dto.response.TopicResponseDTO;
import com.example.app.model.TopicEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    TopicResponseDTO toTopicResponse(TopicEntity entity);

    TopicEntity toTopicEntity(TopicRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateTopicEntity(@MappingTarget TopicEntity entity, TopicRequestDTO request);

    List<TopicResponseDTO> toTopicResponseList(Collection<TopicEntity> entities);
}
