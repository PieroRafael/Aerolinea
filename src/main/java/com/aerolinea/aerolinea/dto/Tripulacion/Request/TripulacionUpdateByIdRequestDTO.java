package com.aerolinea.aerolinea.dto.Tripulacion.Request;

import com.aerolinea.aerolinea.payload.CargoTripulante.ExistFKCargoTripulante;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TripulacionUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 10 , max = 100)
    private String triNombre;

    @NotNull
    @NotBlank
    @Size(min = 10 , max = 100)
    private String triApellido;

    @NotNull
    @ExistFKCargoTripulante
    private Long catId;

}
