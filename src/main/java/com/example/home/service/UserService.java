package com.example.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home.entity.User;
import com.example.home.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        // Check if user exists and password matches (plain text comparison)
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
