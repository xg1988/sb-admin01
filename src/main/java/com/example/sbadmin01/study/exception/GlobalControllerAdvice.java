package com.example.sbadmin01.study.exception;

import com.example.sbadmin01.cmmn.dto.Error;
import com.example.sbadmin01.cmmn.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

// 사용하려면 주석 해제..
//@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity authException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println("=================================");
        System.out.println("GlobalControllerAdvice exception :" + e);



        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        System.out.println("=================================");
        System.out.println("methodArgumentNotValidException exception :" + e);

        List<Error> errorList = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error->{
            System.out.println("error: "+ error);

            FieldError fieldError = (FieldError) error;
            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String value = fieldError.getRejectedValue().toString();

            System.out.println("fieldName: "+ fieldName);
            System.out.println("message: "+ message);
            System.out.println("value: "+ value);

            Error errorObj = new Error();
            errorObj.setField(fieldName);
            errorObj.setMessage(message);
            errorObj.setInvalidValue(value);

            errorList.add(errorObj);
        });

        ErrorResponse errorResponse = setErrorResponse(errorList, request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e){
        System.out.println("=================================");
        System.out.println("missingServletRequestParameterException exception :" + e);

        String fieldName = e.getParameterName();
        String fieldType = e.getParameterType();
        String invalidValue = e.getMessage();
        System.out.println("fieldName: "+ fieldName);
        System.out.println("fieldType: "+ fieldType);
        System.out.println("invalidValue: "+ invalidValue);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    public ErrorResponse setErrorResponse(List<Error> errorList, String url){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(url);
        errorResponse.setResultCode("FAIL");
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        return errorResponse;
    }

}
