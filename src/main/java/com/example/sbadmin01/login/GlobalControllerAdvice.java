package com.example.sbadmin01.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println("=================================");
        System.out.println("GlobalControllerAdvice exception :" + e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("=================================");
        System.out.println("methodArgumentNotValidException exception :" + e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e){
        System.out.println("=================================");
        System.out.println("missingServletRequestParameterException exception :" + e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }


}
