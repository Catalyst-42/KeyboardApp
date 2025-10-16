package ru.task8.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.task8.auth.entity.UserEntity;
import ru.task8.auth.repo.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserEntity register(String username, String password) {
        if (repo.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        UserEntity user = new UserEntity(null, username, encoder.encode(password));
        return repo.save(user);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public boolean checkPassword(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}
