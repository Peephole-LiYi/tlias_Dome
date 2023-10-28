package com.dreamstu.springtlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

///@SpringBootTest
class SpringtliasApplicationTests {

    private String secret = "dreamstu";
    //@Test
    void contextLoads() {
    }


    @Test
    public void testJJwt(){
        HashMap<String, Object> claims = new HashMap<>();

        claims.put("id", 1);
        claims.put("name", "tom");



        //设置签名算法
        String compact = Jwts.builder()
                //注入参数
                .setClaims(claims)
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                //设置算法及密钥
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        System.out.println(compact);
    }



    @Test
    public void testJwtPares(){

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5ODQxMTUyM30.Rne6dOjocFcxi_n3WyA95r1HujXTfwOvytY_J6tuZ_CvWGJ4gyyVjZ0HHikXq5s2954VKirJk5UvR3hogHLqVw")
                .getBody();

        System.out.println(body);
    }

}
