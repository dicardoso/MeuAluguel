package com.example.meualuguel.controllers;

import com.example.meualuguel.config.TokenService;
import com.example.meualuguel.dtos.auth.LoginRequestDTO;
import com.example.meualuguel.dtos.auth.RegisterRequestDTO;
import com.example.meualuguel.dtos.auth.ResponseDTO;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getId(), user.getName(), token));
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setRegistry(body.registry());
            newUser.setEmail(body.email());
            newUser.setPhone(body.phone());
            newUser.setAddress(body.address());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setIs_active(true);

            this.repository.save(newUser);

            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.badRequest().body("User already exists");
    }
}
