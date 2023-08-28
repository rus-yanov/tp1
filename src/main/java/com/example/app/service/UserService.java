package com.example.app.service;

import com.example.app.dto.UserDto;
import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

//    private final PasswordEncoder passwordEncoder;

    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    /*
    public User createUser(UserDto userDto) {
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        return user;
    }

    public User updateUser(final long id, final UserDto userDto) {
        final User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(userToUpdate);
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

     */
}
