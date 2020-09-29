package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.ApplicationWorkFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationWorkFlowRepo extends JpaRepository<ApplicationWorkFlowEntity, Integer> {
    ApplicationWorkFlowEntity findByEmpId(int empId);
}
