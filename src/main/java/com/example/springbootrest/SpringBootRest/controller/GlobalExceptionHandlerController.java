package com.example.springbootrest.SpringBootRest.controller;


import com.example.springbootrest.SpringBootRest.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = {CustomException.class, Exception.class})
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {
        System.out.println(String.format("Exception in handling request to %s: %s",
                request.getRequestURI(), exception.getMessage()));
        exception.printStackTrace();

        if (exception instanceof CustomException) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(((CustomException) exception).getHttpStatus().value()));
        }

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

