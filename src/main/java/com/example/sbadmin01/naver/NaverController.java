package com.example.sbadmin01.naver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaverController {

    @RequestMapping("/test")
    public String test(){
        return "test.html";
    }
}
