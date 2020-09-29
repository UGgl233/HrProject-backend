package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.DigitalDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalDocumentRepo extends JpaRepository<DigitalDocumentEntity, Integer> {
}
