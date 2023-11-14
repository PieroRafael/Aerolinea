package com.aerolinea.aerolinea.dto.Vuelo;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class VueloListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ZonedDateTime vueFHPartida;

    private ZonedDateTime vueFHLlegada;

    private String aviRegistro;

    private String rtaNombre;

    private UUID vueCod;

}
