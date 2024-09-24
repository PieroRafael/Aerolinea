package com.aerolinea.aerolinea.dto.CargoTripulante.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CargoTripulanteUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 6 , max = 25)
    // Validación
    private String catNombre;

}
