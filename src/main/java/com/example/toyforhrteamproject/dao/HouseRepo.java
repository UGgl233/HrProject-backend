package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<HouseEntity, Integer> {
    HouseEntity findByHouseId(Integer id);
}
