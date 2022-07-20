package com.example.sbadmin01.study.controller;

import com.example.sbadmin01.study.dto.User;
import com.example.sbadmin01.study.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    RestTemplateService restTemplateService;

    @GetMapping("/getHello")
    public String getHello(){
        return restTemplateService.hello();
    }

    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("user:{}"+ user);

        return user;
    }
}
