package com.aerolinea.aerolinea.dto.Auth.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageResponse {

    private String message;

    public MessageResponse() {
        message = "Usuario Creado Correctamente";
    }

}
