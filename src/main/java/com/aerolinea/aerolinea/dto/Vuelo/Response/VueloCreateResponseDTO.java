package com.aerolinea.aerolinea.dto.Vuelo.Response;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class VueloCreateResponseDTO {

    private ZonedDateTime vueFHPartida;

    private ZonedDateTime vueFHLlegada;

    private Long aviId;

    private Long rtaId;

}
