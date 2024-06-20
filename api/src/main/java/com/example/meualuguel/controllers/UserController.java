package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.user.UserResponseDTO;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return repository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    @GetMapping("/{user_id}")
    public Optional<User> getStatusById(@PathVariable Long user_id) {
        return repository.findById(user_id);
    }
}
