package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {
    List<UserRoleEntity> findByUserId(int userId);
}
