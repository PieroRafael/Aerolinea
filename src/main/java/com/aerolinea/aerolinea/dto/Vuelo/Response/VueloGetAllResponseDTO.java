package com.aerolinea.aerolinea.dto.Vuelo.Response;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class VueloGetAllResponseDTO {

    private ZonedDateTime vueFHPartida;

    private ZonedDateTime vueFHLlegada;

    private String aviRegistro;

    private String rtaNombre;

    private String vueCod;

}
