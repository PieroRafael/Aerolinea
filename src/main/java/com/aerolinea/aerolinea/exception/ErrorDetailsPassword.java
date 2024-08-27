package com.aerolinea.aerolinea.exception;

import lombok.Data;

@Data
public class ErrorDetailsPassword {

    private String message;

    public ErrorDetailsPassword(String message) {
        this.message = message;
    }

}
