package com.example.toyforhrteamproject.dao;

import com.example.toyforhrteamproject.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByEmpId(int id);
    EmployeeEntity findByPersonId(int id);
    List<EmployeeEntity> findAllByHouseId(int hId);
    void deleteByPersonId(int personId);
}
