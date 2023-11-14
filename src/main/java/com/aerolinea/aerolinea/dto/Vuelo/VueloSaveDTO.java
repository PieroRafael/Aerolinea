package com.aerolinea.aerolinea.dto.Vuelo;

import com.aerolinea.aerolinea.payload.Asiento.ExistFKAvion;
import com.aerolinea.aerolinea.payload.Ruta.ExistFKRuta;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class VueloSaveDTO implements Serializable{

    private static final long serialVersionUID = 1L;

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
