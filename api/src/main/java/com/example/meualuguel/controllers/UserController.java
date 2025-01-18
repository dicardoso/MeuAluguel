package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.user.UserCreateDTO;
import com.example.meualuguel.dtos.user.UserResponseDTO;
import com.example.meualuguel.dtos.user.UserUpdateDTO;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.meualuguel.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository repository;
    private final UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable Long user_id) {
        Optional<User> user = userService.findById(user_id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserCreateDTO data) {
        return ResponseEntity.ok(userService.save(data));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO data) {

        Optional<User> existingUserOpt = userService.findById(id);
        if (existingUserOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = existingUserOpt.get();

        modelMapper.map(data, existingUser);

        User updatedUser = userService.update(existingUser);

        return ResponseEntity.ok(updatedUser);
    }
}
