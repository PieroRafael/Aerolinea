package com.aerolinea.aerolinea.dto.Vuelo.Request;

import com.aerolinea.aerolinea.payload.Asiento.ExistFKAvion;
import com.aerolinea.aerolinea.payload.Ruta.ExistFKRuta;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Data
public class VueloCreateRequestDTO {

    @NotNull
    private ZonedDateTime vueFHPartida;

    @NotNull
    private ZonedDateTime vueFHLlegada;

    @NotNull
    @ExistFKAvion
    private Long aviId;

    @NotNull
    @ExistFKRuta
    private Long rtaId;

}
