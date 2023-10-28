package com.dreamstu.springtlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class SpringtliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtliasApplication.class, args);
    }

}
