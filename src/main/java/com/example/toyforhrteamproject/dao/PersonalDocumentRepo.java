package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.PersonalDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDocumentRepo extends JpaRepository<PersonalDocumentEntity, Integer> {
    List<PersonalDocumentEntity> findByCreateBy(String name);
}
