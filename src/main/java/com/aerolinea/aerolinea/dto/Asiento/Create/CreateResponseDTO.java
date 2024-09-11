package com.aerolinea.aerolinea.dto.Asiento.Create;

import lombok.Data;

@Data
public class CreateResponseDTO {

    private String astNombre;

    private Long aviId;

    private Long tpaId;

    private String message;

    public CreateResponseDTO() {
        this.message = "Asiento Creado Correctamente";
    }

}
