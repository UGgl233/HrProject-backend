package com.example.toyforhrteamproject.controller;

import com.example.toyforhrteamproject.dao.UserRepo;
import com.example.toyforhrteamproject.domain.UserEntity;
import com.example.toyforhrteamproject.response.AuthenticateUserResponse;
import com.example.toyforhrteamproject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRepo userRepo;

    // Kinda a demo to list all users in the DB
    @GetMapping(path = "/users")
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    // Tried to get a user role with username (Need it find whether its hr or not)
    @GetMapping("/userrole")
    public String getUserRole(@RequestParam(name = "username") String username) {
        return userRoleService.getUserRoleByUsername(username);
    }

    // Simplified way to login without JWT token stuff
    @GetMapping("/authenticateuser")
    public AuthenticateUserResponse authenticateUser(@RequestParam String username, @RequestParam String password) {
        return userRoleService.authenticateUser(username, password);
    }

    // Get data for Aiden part
    @GetMapping("personInfo")
    public Map<String, String> getPersonalInfo(@RequestParam String username) {
        return userRoleService.getPersonalInfo(username);
    }


    // Aiden part for personal information edit
    // Same like above dont know how data got flow in
    @PostMapping("/personInfo")
    public boolean editPersonInfo() {
        // call the service
        // with params .. fill in later
        userRoleService.editPersonInfo();
        return false;
    }


}
