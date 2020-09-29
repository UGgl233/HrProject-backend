package com.example.toyforhrteamproject.controller;

import com.example.toyforhrteamproject.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/generateRegistrationToken")
    public boolean generateRegistrationToken(@RequestParam String email) {
        return registrationService.generateRegistrationTokenByHR(email);
    }

    @PostMapping("/notifyHRtoGenerateToken")
    public boolean notifyHRtoGenerateToken(@RequestBody Map<String, String> payload) {
        return registrationService.notifyHRtoGenerateToken(payload.get("username"), payload.get("email"));
    }

    @GetMapping("/authenticate")
    public boolean authenticateByTokenAndSave(@RequestParam String username, @RequestParam String email, @RequestParam String password,
                                                  @RequestParam String registrationToken) {
        return registrationService.authenticateByTokenAndSave(username, email, password, registrationToken);
    }
}
