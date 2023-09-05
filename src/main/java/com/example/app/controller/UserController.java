package com.example.app.controller;

import com.example.app.dto.request.UserCreationDto;
import com.example.app.service.impl.UserServiceImpl;
import com.example.app.dto.request.UserRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + UserController.USER_CONTROLLER_PATH)
public class UserController {

    public static final String USER_CONTROLLER_PATH = "/users";
    public static final String ID = "/{id}";
    private static final String ONLY_OWNER_BY_ID = """
            @userRepository.findById(#id).get().getEmail() == authentication.getName()
        """;
    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserCreationDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping(ID)
    public UserRequestDTO getUserById(@PathVariable final Long id) {
        return userService.getUserById(id);
    }

    @PutMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void updateUser(@PathVariable final long id,
                           @RequestBody @Valid final UserCreationDto dto)  {
        userService.updateUser(id, dto);
    }

    @DeleteMapping(ID)
    @PreAuthorize(ONLY_OWNER_BY_ID)
    public void deleteUser(@PathVariable final long id) {
        userService.deleteUser(id);
    }
}