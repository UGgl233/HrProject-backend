package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.FacilityReportDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityReportDetailRepo extends JpaRepository<FacilityReportDetailEntity, Integer> {
}
