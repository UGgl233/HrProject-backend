package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepo extends JpaRepository<FacilityEntity, Integer> {
    FacilityEntity findByHouseId(int houseId);
}
