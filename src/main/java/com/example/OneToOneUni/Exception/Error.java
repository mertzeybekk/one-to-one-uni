package com.example.OneToOneUni.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Error {
    private String message;
    private List<String>detail;
}
