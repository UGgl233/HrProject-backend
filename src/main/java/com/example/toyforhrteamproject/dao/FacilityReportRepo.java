package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.FacilityReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityReportRepo extends JpaRepository<FacilityReportEntity, Integer> {
    List<FacilityReportEntity> findAllByFacilityReportId(int id);
}
