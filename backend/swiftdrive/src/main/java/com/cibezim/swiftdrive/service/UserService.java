package com.cibezim.swiftdrive.service;

import com.cibezim.swiftdrive.model.User;
import com.cibezim.swiftdrive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (!isUserOldEnough(user.getDateOfBirth())) {
            throw new IllegalArgumentException("User must be at least 25 years old to rent a car.");
        }

        if (!isEmailUnique(user.getEmail())) {
            throw new IllegalArgumentException("Email address is already in use.");
        }

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long userId, User updatedUser) {
        // Retrieve the existing user by userId
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user properties with the details from updatedUser
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setEmail(updatedUser.getEmail());

        // Save the updated user back to the repository
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        User userToDelete = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(userToDelete);
    }

    public void changePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(newPassword);

        userRepository.save(user);
    }

    public void resetPassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(newPassword);

        userRepository.save(user);
    }

    private boolean isUserOldEnough(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dateOfBirth.getYear();

        return age >= 25;
    }

    private boolean isEmailUnique(String email) {
        return userRepository.findByEmail(email) == null;
    }
}
