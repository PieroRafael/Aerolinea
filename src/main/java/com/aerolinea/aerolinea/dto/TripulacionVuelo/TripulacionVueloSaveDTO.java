package com.aerolinea.aerolinea.dto.TripulacionVuelo;

import com.aerolinea.aerolinea.payload.Tripulacion.ExistFKTripulacion;
import com.aerolinea.aerolinea.payload.Vuelo.ExistFKVuelo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TripulacionVueloSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ExistFKTripulacion
    private Long triId;

    @NotNull
    @ExistFKVuelo
    private Long vueId;
}
