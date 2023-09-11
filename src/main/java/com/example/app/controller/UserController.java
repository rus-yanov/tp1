package com.example.app.controller;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;
import com.example.app.model.UserEntity;
import com.example.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}/users/{id}")
public class UserController {

    private final UserService userService;
    private static final String ONLY_OWNER_BY_ID = """
            @userRepository.findById(#id).get().getEmail() == authentication.getName()
        """;

    @Operation(summary = "Create new user")
    @ApiResponse(responseCode = "201", description = "User created")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@Valid @RequestBody UserRequestDTO userDTO) {
        return userService.create(userDTO);
    }

    @Operation(summary = "Get user by id")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = UserEntity.class))))
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Update user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "User with that id not found")
    })
    @PutMapping("/{id}")
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public UserResponseDTO update(@PathVariable Long id,
                                      @Valid @RequestBody UserRequestDTO userDTO) {
        return userService.update(userDTO, id);
    }

    @Operation(summary = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted"),
            @ApiResponse(responseCode = "404", description = "User with that id not found")
    })
    @DeleteMapping("/{id}")
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
