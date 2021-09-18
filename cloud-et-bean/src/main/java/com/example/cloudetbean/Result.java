package com.example.cloudetbean;

import lombok.Data;

@Data
public class Result<T> {
    private int code;

    private String msg;

    private T data;
}
