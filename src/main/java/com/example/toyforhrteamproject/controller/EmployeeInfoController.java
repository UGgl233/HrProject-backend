package com.example.toyforhrteamproject.controller;


import com.example.toyforhrteamproject.response.HrEmployeeInfo;
import com.example.toyforhrteamproject.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/employeeInfo")
public class EmployeeInfoController {
    @Autowired
    private EmployeeInfoService employeeInfoService;

    @GetMapping("/fetchEmployeeInfo")
    public List<HrEmployeeInfo> fetchEmployeeInfo(){
        return employeeInfoService.fetchEmployeeInfo();
    }
}
