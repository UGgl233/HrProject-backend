package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findByPersonId(int pId);
    PersonEntity findByEmail(String email);
}
