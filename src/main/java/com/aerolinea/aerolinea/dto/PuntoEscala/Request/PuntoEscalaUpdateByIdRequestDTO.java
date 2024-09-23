package com.aerolinea.aerolinea.dto.PuntoEscala.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PuntoEscalaUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    //Validación
    private String pesNombrePunto;

    @NotNull
    private Double pesLongitud;

    @NotNull
    private Double pesLatitud;

}
