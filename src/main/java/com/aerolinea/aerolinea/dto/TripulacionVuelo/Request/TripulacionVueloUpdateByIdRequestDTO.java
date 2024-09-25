package com.aerolinea.aerolinea.dto.TripulacionVuelo.Request;

import com.aerolinea.aerolinea.payload.Tripulacion.ExistFKTripulacion;
import com.aerolinea.aerolinea.payload.Vuelo.ExistFKVuelo;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TripulacionVueloUpdateByIdRequestDTO {

    @NotNull
    @ExistFKTripulacion
    private Long triId;

    @NotNull
    @ExistFKVuelo
    private Long vueId;

}
