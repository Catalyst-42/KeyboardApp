package ru.task8.auth.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import ru.task8.auth.config.JwtUtil;
import ru.task8.auth.dto.AuthRequest;
import ru.task8.auth.dto.AuthResponse;
import ru.task8.auth.entity.UserEntity;
import ru.task8.auth.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody AuthRequest request) {
        return service.register(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        UserEntity user = service.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!service.checkPassword(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
    
    @GetMapping("/whoami")
    public Map<String, String> whoami(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(token);
        return Map.of("username", username);
    }
}
