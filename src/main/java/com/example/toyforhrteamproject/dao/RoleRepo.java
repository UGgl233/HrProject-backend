package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRoleId(int roleId);
}
