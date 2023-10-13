package com.example.app.service.impl;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;
import com.example.app.model.UserEntity;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;
import com.example.app.utils.mapper.UserMapper;
import com.example.app.utils.exception.ApplicationNotFoundException;
import jakarta.persistence.EntityExistsException;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO create(UserRequestDTO userRequest) {

        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new EntityExistsException();
        }

        log.info("#create: Create user, user-email - {}", userRequest.getEmail());
        UserEntity newUser = userRepository.save(userMapper
                .toUserEntity(userRequest));
//        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userMapper.toUserResponse(newUser);
    }

    @Override
    public UserResponseDTO getById(UUID id) {

        log.info("#getById: Get user by id, id - {}", id);
        UserEntity user = userRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "User not found, user-id - " + id));

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponseDTO update(UserRequestDTO userRequest, UUID id) {

        log.info("#update: Update user, id - {}", id);
        UserEntity userToUpdate = userRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "User not found, user-id - " + id));

        userMapper.updateUserEntity(userToUpdate, userRequest);
//        userToUpdate.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userMapper.toUserResponse(userToUpdate);
    }

    @Override
    public void delete(UUID id) {

        log.info("#delete: Delete user by id, id - {}", id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "User not found, user-id - " + id);
        }
    }
}
