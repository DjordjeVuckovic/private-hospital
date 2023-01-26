package com.teachhealth.hospitalbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableTransactionManagement
public class HospitalBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalBeApplication.class, args);
    }

}
