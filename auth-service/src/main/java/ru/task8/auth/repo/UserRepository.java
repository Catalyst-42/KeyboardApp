package ru.task8.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.task8.auth.entity.UserEntity;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
