package com.example.sbadmin01.study.controller;

import com.example.sbadmin01.study.annotation.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 권한 차이 부여
 */
@RestController
@RequestMapping("/study/private")
@Auth // 어노테이션 붙어있을 경우 세션이 있을 경우에만 통과하도록
public class PrivateController {

    @GetMapping("hello")
    public String hello(){
        return "private hello";
    }
}
