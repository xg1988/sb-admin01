package com.example.sbadmin01.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/appLogin")
    public Optional<BasicUser> login(@RequestBody BasicUser basicUser){
        String userId = basicUser.getUser_id();
        log.info("userId : {}", userId);

        Optional<BasicUser> rtnBasicUser = loginRepository.findById(userId);
        log.info("rtnBasicUser : {}", rtnBasicUser);


        return rtnBasicUser;
    }
}
