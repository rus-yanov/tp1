package com.example.app.controller;

import com.example.app.dto.request.UserRequestDTO;
import com.example.app.dto.response.UserResponseDTO;
import com.example.app.model.UserEntity;
import com.example.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.example.app.controller.UserController.USER_CONTROLLER_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}" + USER_CONTROLLER_PATH)
public class UserController {

    public static final String USER_CONTROLLER_PATH = "/users";
    public static final String ID = "/{id}";
    private static final String ONLY_OWNER_BY_ID = """
            @userRepository.findById(#id).get().getEmail() == authentication.getName()
        """;

    private final UserService userService;

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
    @GetMapping(ID)
    public UserResponseDTO getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Update user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "User with that id not found")
    })
    @PutMapping(ID)
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
    @DeleteMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}