package com.example.meualuguel.repositories;

import com.example.meualuguel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
