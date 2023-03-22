package com.example.OneToOneUni.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomException {
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<?> customerNotFoundException(CustomNotFoundException customerNotFoundException) {
        List<String> detail = new ArrayList<>();
        detail.add(customerNotFoundException.getMessage());
        Error errorResponse = new Error("Customer Not Found", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerNotNullException.class)
    public ResponseEntity<?>customNotNullException(CustomerNotNullException customerNotNullException){
        List<String>detail=new ArrayList<>();
        detail.add(customerNotNullException.getMessage());
        Error error= new Error("Null Value",detail);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomNotChange.class)
    public ResponseEntity<?>customNotChange(CustomNotChange customNotChange){
        List<String> detail= new ArrayList<>();
        detail.add(customNotChange.getMessage());
        Error error=new Error("Not Data Change",detail);
        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
