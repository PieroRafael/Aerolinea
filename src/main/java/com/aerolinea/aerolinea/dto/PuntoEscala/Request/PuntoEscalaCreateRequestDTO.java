package com.aerolinea.aerolinea.dto.PuntoEscala.Request;

import com.aerolinea.aerolinea.payload.PuntoEscala.UniquePesNombrePunto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PuntoEscalaCreateRequestDTO {

    @NotNull
    @NotBlank
    @UniquePesNombrePunto
    private String pesNombrePunto;

    @NotNull
    private Double pesLongitud;

    @NotNull
    private Double pesLatitud;

}
