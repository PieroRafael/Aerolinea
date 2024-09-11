package com.aerolinea.aerolinea.exception.details;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorDetails {

        private Date timestamp;

        private String message;

        private String details;

        private HttpStatus status;

        public ErrorDetails(HttpStatus status, String message, String details) {
            this.timestamp = new Date();
            this.status = status;
            this.message = message;
            this.details = details;
        }

}


