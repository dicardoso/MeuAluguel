package com.example.meualuguel.repositories;

import com.example.meualuguel.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
