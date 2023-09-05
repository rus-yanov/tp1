package com.example.app.service;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userDTO);

    UserResponseDTO getById(Long id);

    UserResponseDTO update(UserRequestDTO userDTO, Long id);

    void delete(Long id);
}
