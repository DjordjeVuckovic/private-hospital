package com.teachhealth.hospitalbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
public class HospitalBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalBeApplication.class, args);
    }

}
