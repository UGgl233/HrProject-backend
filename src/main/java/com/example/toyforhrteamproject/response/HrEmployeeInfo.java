package com.example.toyforhrteamproject.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HrEmployeeInfo {
    private String fullname;
    private String ssn;
    private String startDate;
    private String visaStatus;
    private String currentCount;
}