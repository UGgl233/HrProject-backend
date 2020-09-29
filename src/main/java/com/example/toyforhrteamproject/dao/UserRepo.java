package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String name);
    UserEntity findByEmail(String email);
    UserEntity findByUserId(int uID);
}
