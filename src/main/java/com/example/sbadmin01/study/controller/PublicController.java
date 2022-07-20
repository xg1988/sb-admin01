package com.example.sbadmin01.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 권한 차이 부여
 */
@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("hello")
    public String hello(){
        return "public hello";
    }
}
