package com.example.app.utils.mapper;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;
import com.example.app.model.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toUserResponse(UserEntity entity);

    UserEntity toUserEntity(UserRequestDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateUserEntity(@MappingTarget UserEntity entity, UserRequestDTO request);
}
