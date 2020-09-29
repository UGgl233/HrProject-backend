package com.example.toyforhrteamproject.service;

import com.example.toyforhrteamproject.dao.RegistrationTokenRepo;
import com.example.toyforhrteamproject.dao.UserRepo;
import com.example.toyforhrteamproject.domain.RegistrationTokenEntity;
import com.example.toyforhrteamproject.domain.UserEntity;
import com.example.toyforhrteamproject.response.AuthenticateUserResponse;
import com.example.toyforhrteamproject.security.util.JavaMailUtil;
import com.example.toyforhrteamproject.security.util.RandomStringGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationTokenRepo registrationTokenRepo;

    @Autowired
    private UserRepo userRepo;

    public boolean generateRegistrationTokenByHR(String email) {
        try {
            String randomizedRegistrationToken = RandomStringGeneratorUtil.randomStringGenerate();
            // Email can't duplicate
            RegistrationTokenEntity registrationTokenEntity = registrationTokenRepo.findByEmail(email);
            if (registrationTokenEntity == null) {
                System.out.println("Email does not exist");
                return false;
            }
            registrationTokenEntity.setToken(randomizedRegistrationToken);
            registrationTokenRepo.save(registrationTokenEntity);
            JavaMailUtil.sendMail(email, randomizedRegistrationToken);
            System.out.println("sent");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean notifyHRtoGenerateToken(String username, String email) {
        try {
            RandomStringGeneratorUtil.randomStringGenerate();
            RegistrationTokenEntity registrationTokenEntity = new RegistrationTokenEntity();
            registrationTokenEntity.setCreatedBy(username);
            registrationTokenEntity.setEmail(email);
            java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_YEAR,3);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            java.sql.Date threeDaysLater = new java.sql.Date(cal.getTimeInMillis());
            registrationTokenEntity.setValidDuration(threeDaysLater);
            registrationTokenRepo.save(registrationTokenEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public AuthenticateUserResponse authenticateByTokenAndSave(String username, String email, String password, String registrationToken) {
        AuthenticateUserResponse authenticateUserResponse = AuthenticateUserResponse.builder().build();
        UserEntity userEntity = userRepo.findByEmail(email);
        RegistrationTokenEntity registrationTokenEntity = registrationTokenRepo.findByEmail(email);
        if (registrationTokenEntity.getToken().equals(registrationToken)) {
            UserEntity newUserEntity = new UserEntity();
            newUserEntity.setEmail(email);
            newUserEntity.setPassword(password);
            newUserEntity.setUsername(username);
            newUserEntity.setModificationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            newUserEntity.setCreateDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            userRepo.save(newUserEntity);
            authenticateUserResponse.setStatus(true);
            authenticateUserResponse.setUsername(username);
            authenticateUserResponse.setUserId(newUserEntity.getUserId());
            return authenticateUserResponse;
        }
        authenticateUserResponse.setStatus(false);
        return authenticateUserResponse;
    }
}
