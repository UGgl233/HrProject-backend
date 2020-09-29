package com.example.toyforhrteamproject.service;

import com.example.toyforhrteamproject.dao.*;
import com.example.toyforhrteamproject.domain.*;
import com.example.toyforhrteamproject.response.AuthenticateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private FacilityRepo facilityRepo;

    @Autowired
    private FacilityReportRepo facilityReportRepo;

    @Autowired
    private ApplicationWorkFlowRepo applicationWorkFlowRepo;

    // @TODO: Reorg
    @Autowired
    private VisaStatusRepo visaStatusRepo;

    public String getUserRoleByUsername(String username) {
        UserEntity user = userRepo.findByUsername(username);
        System.out.println(user.toString());
        List<UserRoleEntity> userRole = userRoleRepo.findByUserId(user.getUserId());
        StringBuilder sb = new StringBuilder();
        for (UserRoleEntity ure : userRole) {
            sb.append(roleRepo.findByRoleId(ure.getRoleId()).getRolename());
        }
        return sb.toString();
    }

    public AuthenticateUserResponse authenticateUser(String username, String password) {
        AuthenticateUserResponse authenticateUserResponse = AuthenticateUserResponse.builder().build();
        UserEntity user = userRepo.findByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                authenticateUserResponse.setStatus(true);
                authenticateUserResponse.setUserId(user.getUserId());
                authenticateUserResponse.setUsername(user.getUsername());
                authenticateUserResponse.setRole(getUserRoleByUsername(username));
                return authenticateUserResponse;
            } else {
                authenticateUserResponse.setStatus(false);
                return authenticateUserResponse;
            }
        }
        authenticateUserResponse.setStatus(false);
        return authenticateUserResponse;
    }

    // save data from onboarding process (saad part).. Param not fixed yet\
    // And we need to save in 2 seperate tables due to requirenments
    @Transactional
    public boolean saveOnboardingProcess(String fName, String mName, String lName, String pName, String currentAddress,
                                         String phone, String email, String carMake, String carModel, String carColor,
                                         String ssn, String dob, String gender, String visaStatus, String citizenship,
                                         String dl, String dlNum, String dlExp,
                                         String refFName, String refMName, String refLName, String refPhone, String refEmail, String refRel,
                                         String emFName, String emLName, String emPhone, String emEmail, String emRel) {

        PersonEntity pe = new PersonEntity();
        pe.setFirstname(fName);
        pe.setMiddlename(mName);
        pe.setLastname(lName);
        pe.setEmail(email);
        pe.setCellphone(phone);
        pe.setGender(gender);
        pe.setSsn(ssn);
        pe.setDob(Date.valueOf(dob));
        personRepo.save(pe);
        // initilzie new person from params and then save it to personEntity

        PersonEntity pp = personRepo.findByEmail(email);

        // save personId in the user table
        UserEntity userEntity = userRepo.findByEmail(email);
        userEntity.setPersonId(pp.getPersonId());

        System.out.println(pp.getFirstname()+pp.getLastname());
        EmployeeEntity ee = new EmployeeEntity();
//ee.setAvartar(avatar);
        ee.setPersonId(pp.getPersonId());
        ee.setCar(carMake+" "+carModel+ " "+carColor);
        if(!citizenship.equals("")) {
            String type = "";
            VisaStatusEntity v = new VisaStatusEntity();
            if(citizenship.equals("other")){
                type = visaStatus;
                v.setVisaType(visaStatus);
                v.setIsActive(Byte.parseByte("1"));
                v.setModificationDate(Date.valueOf("1900-01-01"));
                visaStatusRepo.save(v);
            }
            else{
                type = citizenship;
                v.setVisaType(citizenship);
                v.setIsActive(Byte.parseByte("1"));
                v.setModificationDate(Date.valueOf("1900-01-01"));
                visaStatusRepo.save(v);
            }

            VisaStatusEntity vv = visaStatusRepo.findByVisaType(type);
            ee.setVisaStatusId(vv.getVisaStatusId());
        }
        if(!dl.equals("No")) {
            ee.setDriverLisence(Integer.parseInt(dlNum));
            ee.setDriverLisenceExpirationDate(Date.valueOf(dlExp));
        }
        employeeRepo.save(ee);


//save the contact details
        if(!refFName.equals("") && !refLName.equals("")) {
            ContactEntity cc = new ContactEntity();
            cc.setPersonId(pp.getPersonId());
            cc.setName(refFName + " " + refMName + " " + refLName);
            cc.setPhone(refPhone);
            cc.setEmail(refEmail);
            cc.setIsReferrence(Byte.parseByte("1"));
            contactRepo.save(cc);
        }
        if(!emFName.equals("") && !emLName.equals("")){
            if(emFName.equals(refFName) && emLName.equals(refLName)){
                ContactEntity cc = contactRepo.findByPersonId(pp.getPersonId());
                cc.setIsEmergency(Byte.parseByte("1"));
                contactRepo.save(cc);
            }
            else{
                ContactEntity cc = new ContactEntity();
                cc.setPersonId(pp.getPersonId());
                cc.setName(emFName + " " + emLName);
                cc.setPhone(emPhone);
                cc.setEmail(emEmail);
                cc.setIsReferrence(Byte.parseByte("1"));
                contactRepo.save(cc);
            }
        }

        //save the address details
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1(currentAddress);
        addressEntity.setPersonId(pp.getPersonId());
        addressRepo.save(addressEntity);

        return true;
    }

    public Map<String, String> getPersonalInfo(String username) {
        Map<String, String> map = new HashMap<>();
        UserEntity userEntity = userRepo.findByUsername(username);
        int personalId = userEntity.getPersonId();
        map.put("personinfo", personRepo.findById(personalId).toString());
        // And Contact, addres and more... above just check if work or not
        return map;

    }

    // Aiden part() like above
    public void editPersonInfo() {
        // Address, contact, employee we might need to update all of them.. depends on frontend implementation

    }

    // @TODO: Reorg
    public void saveVisaStatus(VisaStatusEntity visa) {
        visaStatusRepo.save(visa);
    }


    public Map<String,Object> getHousingInfo(int userID) {
        Map<String,Object> map = new HashMap<>();

        UserEntity user = userRepo.findByUserId(userID);

        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(user.getPersonId());
        //get HousId from here and get all employees at the house
        List<EmployeeEntity> employeeList = employeeRepo.findAllByHouseId(employeeEntity.getHouseId());
        //get the house details of current user
        HouseEntity houseEntity = houseRepo.findByHouseId(employeeEntity.getHouseId());
        map.put("address", houseEntity.getAddress());
        map.put("numberOfPerson",houseEntity.getNumberOfPerson());
        //now get the Person details of All employees at given address
        List<Map<String, String>> list = new ArrayList<>();
        for(EmployeeEntity ee: employeeList){
            PersonEntity person = personRepo.findByPersonId(ee.getPersonId());
            Map<String, String> empMap = new HashMap<>();
            empMap.put("FirstName",person.getFirstname());
            empMap.put("LastName",person.getLastname());
            empMap.put("Phone",person.getCellphone());
            list.add(empMap);
        }
        map.put("employees",list);
        return map;
    }
    public List<Map<String, String>> getFacilityInfo( int userId){

        List<Map<String, String>> list = new ArrayList<>();
        UserEntity user = userRepo.findByUserId(userId);
        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(user.getPersonId());
        HouseEntity houseEntity = houseRepo.findByHouseId(employeeEntity.getHouseId());

        FacilityEntity facilityEntity = facilityRepo.findByHouseId(houseEntity.getHouseId());
        List<FacilityReportEntity> facilityReportEntity = facilityReportRepo.findAllByFacilityReportId(facilityEntity.getFacilityId());
        for(FacilityReportEntity fr: facilityReportEntity){
            Map<String,String> map = new HashMap<>();
            map.put("title",fr.getTitle());
            map.put("description", fr.getDescription());
            map.put("date",fr.getReportDate()+"");
            map.put("status", fr.getStatus());
            EmployeeEntity employeeEntity1 = employeeRepo.findByEmpId(fr.getEmpId());
            PersonEntity pp = personRepo.findByPersonId(employeeEntity1.getPersonId());
            map.put("createdBy", pp.getFirstname()+" "+ pp.getMiddlename()+" "+ pp.getLastname());
            list.add(map);
        }
        return list;
    }

    @Transactional
    public void saveFacilityReport(int userId, String title, String desc, String date, String status){
        FacilityReportEntity facilityReportEntity = new FacilityReportEntity();
        facilityReportEntity.setTitle(title);
        facilityReportEntity.setDescription(desc);
        facilityReportEntity.setReportDate(Date.valueOf(date));
        facilityReportEntity.setStatus(status);
        UserEntity user = userRepo.findByUserId(userId);
        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(user.getPersonId());
        facilityReportEntity.setEmpId(employeeEntity.getEmpId());
        facilityReportRepo.save(facilityReportEntity);
    }

    public Map<String, String> fetchApplicationWorkFlow(String email) {
        Map<String, String> map  = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        System.out.println(email);
        PersonEntity personEntity = personRepo.findByEmail(email);
        sb.append(personEntity.getLastname() + personEntity.getFirstname());
        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(personEntity.getPersonId());
        ApplicationWorkFlowEntity applicationWorkFlowEntity =
                applicationWorkFlowRepo.findByEmpId(employeeEntity.getEmpId());
        if (applicationWorkFlowEntity == null) {
            map.put("res", "");
        } else {
            map.put("res", sb.toString());
        }
        return map;
    }

    public void approveApplication(String email) {
        PersonEntity personEntity = personRepo.findByEmail(email);
        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(personEntity.getPersonId());
        ApplicationWorkFlowEntity applicationWorkFlowEntity =
                applicationWorkFlowRepo.findByEmpId(employeeEntity.getEmpId());
        applicationWorkFlowEntity.setStatus("completed");
        applicationWorkFlowRepo.save(applicationWorkFlowEntity);

    }

    @Transactional
    public void rejectApplication(String email) {
        PersonEntity personEntity = personRepo.findByEmail(email);
        int personId = personEntity.getPersonId();
        EmployeeEntity employeeEntity = employeeRepo.findByPersonId(personId);
        ApplicationWorkFlowEntity applicationWorkFlowEntity =
                applicationWorkFlowRepo.findByEmpId(employeeEntity.getEmpId());
        applicationWorkFlowEntity.setStatus("rejected");
        applicationWorkFlowRepo.save(applicationWorkFlowEntity);
        addressRepo.deleteByPersonId(personId);
        contactRepo.deleteByPersonId(personId);
        employeeRepo.deleteByPersonId(personId);
        personRepo.deleteById(personId);
    }
}
