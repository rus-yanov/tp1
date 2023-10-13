package com.example.app.service;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;

import java.util.UUID;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userDTO);

    UserResponseDTO getById(UUID id);

    UserResponseDTO update(UserRequestDTO userDTO, UUID id);

    void delete(UUID id);
}
