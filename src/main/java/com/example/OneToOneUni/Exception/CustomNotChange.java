package com.example.OneToOneUni.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class CustomNotChange extends  RuntimeException{
    public CustomNotChange(String message){
        super((message));
    }

}
