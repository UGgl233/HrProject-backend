package com.example.toyforhrteamproject.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AuthenticateUserResponse {
    boolean status;
    int userId;
    String username;
    String role;
}
