package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.RegistrationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationTokenRepo extends JpaRepository<RegistrationTokenEntity, Integer> {
    RegistrationTokenEntity findByEmail(String email);
}
