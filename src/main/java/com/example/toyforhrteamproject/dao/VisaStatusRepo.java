package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.VisaStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaStatusRepo extends JpaRepository<VisaStatusEntity, Integer> {
    VisaStatusEntity findAllByCreateUser(String user);
    VisaStatusEntity findByVisaType(String type);
}
