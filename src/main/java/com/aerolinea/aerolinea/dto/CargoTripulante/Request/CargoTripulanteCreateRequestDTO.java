package com.aerolinea.aerolinea.dto.CargoTripulante.Request;

import com.aerolinea.aerolinea.payload.CargoTripulante.UniqueCatNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CargoTripulanteCreateRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 6 , max = 25)
    @UniqueCatNombre
    private String catNombre;

}
