package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Integer> {
    ContactEntity findByPersonId(int personId);
    List<ContactEntity> findAllByPersonId(int personId);
    void deleteByPersonId(int personId);

    ContactEntity findByContactId(Integer contactId);
}
