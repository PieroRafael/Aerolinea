package com.aerolinea.aerolinea.dto.Tripulacion.Request;

import com.aerolinea.aerolinea.payload.CargoTripulante.ExistFKCargoTripulante;
import com.aerolinea.aerolinea.payload.Tripulacion.UniqueTriApellido;
import com.aerolinea.aerolinea.payload.Tripulacion.UniqueTriNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TripulacionCreateRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 10 , max = 100)
    @UniqueTriNombre
    private String triNombre;

    @NotNull
    @NotBlank
    @Size(min = 10 , max = 100)
    @UniqueTriApellido
    private String triApellido;

    @NotNull
    @ExistFKCargoTripulante
    private Long catId;

}
