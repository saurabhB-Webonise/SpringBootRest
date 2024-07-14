package com.example.springbootrest.SpringBootRest.controller;

import com.example.springbootrest.SpringBootRest.exception.CreditLimitExceedException;
import com.example.springbootrest.SpringBootRest.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseController<T> {
//    @ExceptionHandler({CustomException.class, CreditLimitExceedException.class})
//    public ResponseEntity<T> handleCreditCardError(CustomException ex) {
//        System.out.println(ex.getMessage());
//       // return new ResponseEntity<T>(ex.getMessage(),HttpStatus.valueOf(ex.getHttpStatus().value()));
//        return ResponseEntity.status(HttpStatus.valueOf(ex.getHttpStatus().value())).body((T)"working");
//       // return new ResponseEntity<>(message, HttpStatus.OK);
//    }
}
