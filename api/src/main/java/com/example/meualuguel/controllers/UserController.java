package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.user.UserCreateDTO;
import com.example.meualuguel.dtos.user.UserResponseDTO;
import com.example.meualuguel.dtos.user.UserUpdateDTO;
import com.example.meualuguel.exceptions.ResourceNotFoundException;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.meualuguel.services.UserService;

import java.util.List;

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
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long user_id) {
        User user = userService.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + user_id + " não encontrado."));
        UserResponseDTO responseDTO = new UserResponseDTO(user);
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserCreateDTO data) {
        return ResponseEntity.ok(new UserResponseDTO(userService.save(data)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO data) {
        User updatedUser = userService.update(id, data);
        return ResponseEntity.ok(new UserResponseDTO(updatedUser));
    }

}
