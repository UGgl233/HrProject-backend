package com.example.toyforhrteamproject.security.util;

import java.security.SecureRandom;
import java.util.Random;

import static com.example.toyforhrteamproject.constant.Constant.tokenGenerationList;

public class RandomStringGeneratorUtil {

    private static SecureRandom rnd = new SecureRandom();

    public static String randomStringGenerate(){
        Random random = new Random();
        int len = random.nextInt(15 - 10 + 1) + 10;
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( tokenGenerationList.charAt( rnd.nextInt(tokenGenerationList.length()) ) );
        return sb.toString();
    }
}
