package com.example.sbadmin01.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class APIController {

    @GetMapping("")
    public BasicUser get(@RequestParam(required = false) String user_id, @RequestParam(required = false) String password){
        BasicUser basicUser = new BasicUser();
        basicUser.setUser_id(user_id);
        basicUser.setPassword(password);

        System.out.println("basicUser: " +basicUser);
        return basicUser;
    }

    @PostMapping("")
    public BasicUser post(@Valid @RequestParam BasicUser basicUser){
        System.out.println("basicUser: " +basicUser);
        System.out.println("basicUser: " +basicUser);
        return basicUser;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("=================================");
        System.out.println("APIController methodArgumentNotValidException exception :" + e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e){
        System.out.println("=================================");
        System.out.println("APIController missingServletRequestParameterException exception :" + e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }
}
