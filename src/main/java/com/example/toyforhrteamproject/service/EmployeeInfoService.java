package com.example.toyforhrteamproject.service;

import com.example.toyforhrteamproject.dao.*;
import com.example.toyforhrteamproject.domain.EmployeeEntity;
import com.example.toyforhrteamproject.domain.PersonEntity;
import com.example.toyforhrteamproject.domain.VisaStatusEntity;
import com.example.toyforhrteamproject.response.HrEmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeInfoService {
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private VisaStatusRepo visaStatusRepo;

    public List<HrEmployeeInfo> fetchEmployeeInfo(){
        List<HrEmployeeInfo> resList = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        int totalNum = employeeEntities.size();
        for (int i = 0; i < totalNum; i++ ){
            int personId = employeeEntities.get(i).getPersonId();
            Optional<PersonEntity> personEntity = personRepo.findById(personId);
            String fullname = personEntity.get().getFirstname()+" "+personEntity.get().getLastname();
            String ssn = personEntity.get().getSsn();
            String startDate = String.valueOf(employeeEntities.get(i).getStartDate());
            Optional<VisaStatusEntity> visaStatusEntity = visaStatusRepo.findById(employeeEntities.get(i).getVisaStatusId().intValue());
            String visaStatus = visaStatusEntity.get().getVisaType();
            String currentCount = "<"+String.valueOf(i+1)+"/"+String.valueOf(totalNum)+">";
            HrEmployeeInfo itrtr = HrEmployeeInfo.builder().fullname(fullname).ssn(ssn).startDate(startDate).visaStatus(visaStatus).currentCount(currentCount).build();
            resList.add(itrtr);
        }
        return resList;
    }
}