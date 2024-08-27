package com.aerolinea.aerolinea.exception.custom;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException(String message) {
        super(message);
    }

}
