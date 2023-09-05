package com.example.app.service.impl;

import com.example.app.dto.request.UserCreationDto;
import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl  {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void createUser(UserCreationDto userDto) {
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(final long id, final UserCreationDto userDto) {
        final User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setRole(userDto.getRole());
        userToUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userToUpdate);
    }

    public void deleteUser(long id) {
        final User userToDelete = userRepository.findById(id).get();
        userRepository.delete(userToDelete);
    }

    public String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getCurrentUser() {
        return userRepository.findByEmail(getCurrentUserId()).get();
    }
}
