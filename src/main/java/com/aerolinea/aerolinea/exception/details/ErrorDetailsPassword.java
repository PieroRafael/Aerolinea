package com.aerolinea.aerolinea.exception.details;

import lombok.Data;

@Data
public class ErrorDetailsPassword {

    private String message;

    public ErrorDetailsPassword(String message) {
        this.message = message;
    }

}
