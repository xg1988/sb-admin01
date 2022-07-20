package com.example.sbadmin01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SbAdmin01Application {

    public static void main(String[] args) {
        SpringApplication.run(SbAdmin01Application.class, args);
    }

}
