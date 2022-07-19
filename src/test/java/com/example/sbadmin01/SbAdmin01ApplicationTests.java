package com.example.sbadmin01;

import com.example.sbadmin01.login.BasicUser;
import com.example.sbadmin01.login.LoginRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SbAdmin01ApplicationTests {

    @Autowired
    LoginRepository loginRepository;

    @Test
    void contextLoads() {
        /*List<User> userList = userRepository.findAll();

        for (User user: userList){
            System.out.println(user.toString());
        }*/
/*
        basicBbsRepositoy.findAll().forEach(System.out::println);

        System.out.println(basicBbsRepositoy.findById("2"));*/

        //basicUserRepository.
        //System.out.println(basicUserRepository.findById("test"));

        Optional<BasicUser> basicUser =  loginRepository.findById("test");

        System.out.println(basicUser);
    }

}
