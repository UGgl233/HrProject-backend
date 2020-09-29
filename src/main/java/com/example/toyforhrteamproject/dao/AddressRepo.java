package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Integer>{
    List<AddressEntity> findByPersonId(int personId);
}
