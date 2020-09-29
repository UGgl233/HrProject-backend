package com.example.toyforhrteamproject.service;

import com.example.toyforhrteamproject.dao.*;
import com.example.toyforhrteamproject.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class PersonalInfoService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private VisaStatusRepo visaStatusRepo;

    public Map<String, String> fetchPersonalInfo(int userId) {
        Map<String, String> resMap = new HashMap<>();
        Optional<UserEntity> userEntity = userRepo.findById(userId);
        if (!userEntity.isPresent()) {
            return resMap;
        } else {
            int personId = userEntity.get().getPersonId();
            Optional <PersonEntity>  personEntity = personRepo.findById(personId);
            resMap.put("name", personEntity.get().getLastname() + " "
                    + personEntity.get().getFirstname());
            resMap.put("dob", personEntity.get().getDob().toString());
            resMap.put("gender", personEntity.get().getGender());
            resMap.put("ssn", personEntity.get().getSsn());
            int age = 120 - personEntity.get().getDob().getYear();
            resMap.put("age", String.valueOf(age));

            List<AddressEntity> addressEntities = addressRepo.findByPersonId(personId);
            resMap.put("primaryAddressLine1", addressEntities.get(0).getAddressLine1());
            resMap.put("primaryAddressLine2", addressEntities.get(0).getAddressLine2());
            resMap.put("primaryAddressCity", addressEntities.get(0).getCity());
            resMap.put("primaryAddressState", addressEntities.get(0).getStateAbbr());
            resMap.put("primaryAddressZip", addressEntities.get(0).getZipcode().toString());

            if (addressEntities.size() > 1) {
                resMap.put("secondAddressLine1", addressEntities.get(1).getAddressLine1());
                resMap.put("secondAddressLine2", addressEntities.get(1).getAddressLine2());
                resMap.put("secondAddressCity", addressEntities.get(1).getCity());
                resMap.put("secondAddressState", addressEntities.get(1).getStateAbbr());
                resMap.put("secondAddressZip", addressEntities.get(1).getZipcode().toString());
            }

            resMap.put("personalEmail", personEntity.get().getEmail());
            resMap.put("cell", personEntity.get().getCellphone());
            resMap.put("workPhone", personEntity.get().getAlternatePhone());

            EmployeeEntity employeeEntity = employeeRepo.findByPersonId(personId);
            resMap.put("title", employeeEntity.getTitle());
            resMap.put("authStart", String.valueOf(employeeEntity.getVisaStartDate()));
            resMap.put("authEnd", String.valueOf(employeeEntity.getVisaEndDate()));
            resMap.put("empStart", String.valueOf(employeeEntity.getStartDate()));
            resMap.put("empEnd", String.valueOf(employeeEntity.getEndDate()));

            Optional<VisaStatusEntity> visaStatusEntity = visaStatusRepo.findById(employeeEntity.getVisaStatusId().intValue());
            resMap.put("workAuth", visaStatusEntity.get().getVisaType());

            List<ContactEntity> contactEntity = contactRepo.findAllByPersonId(personId);
            for (int i = 0; i < contactEntity.size(); i++){
                if (contactEntity.get(i).getIsEmergency()==1){
                    resMap.put("emergencyFullName", contactEntity.get(i).getName());
                    resMap.put("emergencyPhone", contactEntity.get(i).getPhone());
                    resMap.put("emergencyAddress", contactEntity.get(i).getEmail());
                }
            }

            return resMap;
        }
    }

    public boolean savePersonalInfo(Map<String, String> map){
        try {

            UserEntity userEntity = userRepo.findByUserId(parseInt(map.get("userId")));

            PersonEntity personEntity = personRepo.findByPersonId(userEntity.getPersonId());
            String name = map.get("name");
            String[] names = name.split("\\s+");
            personEntity.setFirstname(names[0]);
            personEntity.setLastname(names[names.length-1]);
            Date dob = Date.valueOf(map.get("dob"));
            personEntity.setDob(dob);
            personEntity.setGender(map.get("gender"));
            personEntity.setSsn(map.get("ssn"));

            personEntity.setCellphone(map.get("cell"));
            personEntity.setEmail(map.get("personalEmail"));
            personEntity.setAlternatePhone(map.get("workPhone"));
            personRepo.save(personEntity);

            List<AddressEntity> addressEntities = addressRepo.findByPersonId(userEntity.getPersonId());
            addressEntities.get(0).setAddressLine1(map.get("primaryAddressLine1"));
            addressEntities.get(0).setAddressLine2(map.get("primaryAddressLine2"));
            addressEntities.get(0).setCity(map.get("primaryAddressCity"));
            addressEntities.get(0).setStateAbbr(map.get("primaryAddressState"));
            addressEntities.get(0).setZipcode(parseInt(map.get("primaryAddressZip")));
            if (addressEntities.size() > 1) {
                addressEntities.get(1).setAddressLine1(map.get("secondAddressLine1"));
                addressEntities.get(1).setAddressLine2(map.get("secondAddressLine2"));
                addressEntities.get(1).setCity(map.get("secondAddressCity"));
                addressEntities.get(1).setStateAbbr(map.get("secondAddressState"));
                addressEntities.get(1).setZipcode(parseInt(map.get("secondAddressZip")));
            }
            addressRepo.saveAll(addressEntities);

            EmployeeEntity employeeEntity = employeeRepo.findByPersonId(userEntity.getPersonId());
            employeeEntity.setTitle(map.get("title"));
            employeeEntity.setStartDate(Date.valueOf(map.get("empStart")));
            employeeEntity.setEndDate(Date.valueOf(map.get("empEnd")));
            employeeEntity.setVisaStartDate(Date.valueOf(map.get("authStart")));
            employeeEntity.setVisaEndDate(Date.valueOf(map.get("authEnd")));
            employeeRepo.save(employeeEntity);

            Optional<VisaStatusEntity> visaStatusEntity = visaStatusRepo.findById(employeeEntity.getVisaStatusId().intValue());
            visaStatusEntity.get().setVisaType(map.get("workAuth"));
            visaStatusRepo.save(visaStatusEntity.get());

            List<ContactEntity> contactEntities = contactRepo.findAllByPersonId(userEntity.getPersonId());
            for (int i = 0; i < contactEntities.size(); i++){
                if (contactEntities.get(i).getIsEmergency()==1){
                    contactEntities.get(i).setName(map.get("emergencyFullName"));
                    contactEntities.get(i).setPhone(map.get("emergencyPhone"));
                    contactEntities.get(i).setEmail(map.get("emergencyAddress"));
                }
            }
            contactRepo.saveAll(contactEntities);




            return true;
        } catch (Exception e) {
            System.out.println("update fails!");
            return false;
        }
    }
}