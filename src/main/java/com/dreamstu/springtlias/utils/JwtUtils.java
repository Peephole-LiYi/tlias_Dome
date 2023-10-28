package com.dreamstu.springtlias.utils;/*
Name: JwtUtils
CreatDate: 2023/10/27 20:03
*/

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "dreamstu";
    private static Long expire = 43200000L;


    /**
     * @Description 生成JWT令牌
     * @Author lhbll
     * @Date 2023/10/27 20:09
     * @Version 1.0
    */
    public static String generateJwt(Map<String, Object> claims){

        String jwt = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS512, signKey)
                .compact();

        return jwt;
    }


    /**
     * @Description 解析JWT令牌
     * @Author lhbll
     * @Date 2023/10/27 20:09
     * @Version 1.0
    */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }
}
