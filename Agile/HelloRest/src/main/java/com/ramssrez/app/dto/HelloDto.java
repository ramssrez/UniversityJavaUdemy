package com.ramssrez.app.dto;

import lombok.Data;

@Data
//(*message:"Hello*)
public class HelloDto {

    private String message;

    public HelloDto(String message) {
        this.message = message;
    }
}
