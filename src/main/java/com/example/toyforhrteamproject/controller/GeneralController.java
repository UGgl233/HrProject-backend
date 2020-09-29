package com.example.toyforhrteamproject.controller;

import com.example.toyforhrteamproject.dao.PersonalDocumentRepo;
import com.example.toyforhrteamproject.dao.VisaStatusRepo;
import com.example.toyforhrteamproject.domain.PersonalDocumentEntity;
import com.example.toyforhrteamproject.domain.VisaStatusEntity;
import com.example.toyforhrteamproject.service.S3Services;
import com.example.toyforhrteamproject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class GeneralController {
    @Autowired
    private VisaStatusRepo visaStatusRepo;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private S3Services s3Services;

    @Autowired
    private PersonalDocumentRepo personalDocumentRepo;

    // Grace work
    @GetMapping("/Detail/{name}")
    public VisaStatusEntity getEmployeeDetail(@PathVariable(value = "name") String name) {
        VisaStatusEntity visaUser = visaStatusRepo.findAllByCreateUser(name);
        return visaUser;
    }

    @PostMapping("/visa")
    public VisaStatusEntity saveVisaStatus (@RequestBody VisaStatusEntity visaStatusEntity) {
//        System.out.println("save successfully");
//        System.out.println(visaStatusEntity.getVisaType());
//        System.out.println(visaStatusEntity.getCreateUser());
        userRoleService.saveVisaStatus(visaStatusEntity);

        return visaStatusEntity;
    }

    @PostMapping("/personalDocument")
    public PersonalDocumentEntity savePersonalDocument(@RequestBody PersonalDocumentEntity document) {
        System.out.println("save successfully");
        System.out.println(document.getCreateBy());
        System.out.println(document.getPath());
        personalDocumentRepo.save(document);
        return document;
    }

    //upload
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
        String keyName = file.getOriginalFilename();
        s3Services.uploadFile(keyName, file);
        return "Upload Successfully -> KeyName = " + keyName;
    }

    //download
    @GetMapping("/api/file/{keyname}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname) {
        ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(keyname);

        return ResponseEntity.ok()
                .contentType(contentType(keyname))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + keyname + "\"")
                .body(downloadInputStream.toByteArray());
    }

    @GetMapping("/file/{name}")
    public List<PersonalDocumentEntity> getFile(@PathVariable String name) {

        List<PersonalDocumentEntity> list = personalDocumentRepo.findByCreateBy(name);
        return list;
    }

    /*
     * List ALL Files
     */
    @GetMapping("/api/file/all")
    public List<String> listAllFiles(){
        return s3Services.listFiles();
    }

    @GetMapping("/AllDocumentInfo")
    public List<VisaStatusEntity> listAllPersonalDocument() {
        return visaStatusRepo.findAll();
    }

    private MediaType contentType(String keyname) {
        String[] arr = keyname.split("\\.");
        String type = arr[arr.length-1];
        switch(type) {
            case "txt": return MediaType.TEXT_PLAIN;
            case "png": return MediaType.IMAGE_PNG;
            case "jpg": return MediaType.IMAGE_JPEG;
            default: return MediaType.APPLICATION_OCTET_STREAM;
        }
    }



    // Saad part there are 2 ways to do it either with Request Body or just request params.
    @PostMapping("/onboarding")
    public boolean onboarding(@RequestParam(value = "fName") String fName, @RequestParam(value = "mName") String mName,
                              @RequestParam(value = "lName") String lName, @RequestParam(value = "pName") String pName,
                              @RequestParam(value = "curAdd") String currentAddress,
                              @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email,
                              @RequestParam(value = "carMake") String carMake, @RequestParam(value = "carModel") String carModel,
                              @RequestParam(value = "carColor") String carColor, @RequestParam(value = "ssn") String ssn,
                              @RequestParam(value = "dob") String dob, @RequestParam(value = "gender") String gender,
                              @RequestParam(value = "visa") String visaStatus, @RequestParam(value = "ctz") String citizenship,
                              @RequestParam(value = "dl") String dl,
                              @RequestParam(value = "dlNum") String dlNum, @RequestParam(value = "refFName") String refFName,
                              @RequestParam(value = "refPhone") String refPhone, @RequestParam(value = "refLName") String refLName,
                              @RequestParam(value = "refMName") String refMName, @RequestParam(value = "dlExp") String dlExp,
                              @RequestParam(value = "refEmail") String refEmail,@RequestParam(value = "refRel") String refRel,
                              @RequestParam(value = "emFName") String emFName, @RequestParam(value = "emLName") String emLName,
                              @RequestParam(value = "emPhone") String emPhone,@RequestParam(value = "emEmail") String emEmail,
                              @RequestParam(value = "emRel") String emRel) {

        return userRoleService.saveOnboardingProcess(fName, mName, lName, pName, currentAddress, phone, email, carMake,
                carModel, carColor, ssn, dob, gender, visaStatus, citizenship, dl, dlNum, dlExp, refFName,
                refMName, refLName, refPhone, refEmail, refRel, emFName, emLName, emPhone, emEmail, emRel);
    }

    @GetMapping("/housing")
    public Map<String, Object> getHousingInfo(@RequestParam(value = "userId") int uId){
        return userRoleService.getHousingInfo(1);
    }

    @GetMapping("/facility-report")
    public List<Map<String, String>> getFacilityInfo(@RequestParam(value = "userId") int userId){
        return userRoleService.getFacilityInfo(userId);

    }
    @PostMapping("/facility-report")
    public void saveFacilityReport(@RequestParam(value = "title") String title, @RequestParam(value = "desc") String description,@RequestParam(value = "userId") int userId, @RequestParam(value = "date") String date){
        userRoleService.saveFacilityReport(userId,title,description,date,"In Progress");
    }
}
