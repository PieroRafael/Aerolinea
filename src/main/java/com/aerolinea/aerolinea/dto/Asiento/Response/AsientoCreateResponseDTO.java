package com.aerolinea.aerolinea.dto.Asiento.Response;

import lombok.Data;

@Data
public class AsientoCreateResponseDTO {

    private String astNombre;

    private Long aviId;

    private Long tpaId;

    private String message;

    public AsientoCreateResponseDTO() {
        this.message = "Asiento Creado Correctamente";
    }

}
