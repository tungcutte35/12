package com.example.KhoaHoc_Springboot_CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class KhoahocSpringbootCRUDApplication {

    public static void main(String[] args) {

        SpringApplication.run(KhoahocSpringbootCRUDApplication.class, args);
    }

}
