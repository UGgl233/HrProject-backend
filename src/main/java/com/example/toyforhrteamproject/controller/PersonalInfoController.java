package com.example.toyforhrteamproject.controller;

import com.example.toyforhrteamproject.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @GetMapping("/fetchPersonalInfo")
    public Map<String, String> fetchPersonalInfo(@RequestParam Integer userId){
        return personalInfoService.fetchPersonalInfo(userId);
    }

    @PostMapping("/savePersonalInfo")
    public boolean savePersonalInfo(@RequestBody Map<String, String> map) {
        return personalInfoService.savePersonalInfo(map);
    }
}