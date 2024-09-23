package com.aerolinea.aerolinea.dto.Pasajero.Request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PasajeroUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    // Validación
    private String pasNombre;

    @NotNull
    @NotBlank
    // Validación
    private String pasApellido;

    @NotNull
    @Positive
    @Min(1)
    @Max(120)
    private int pasEdad;

    @NotNull
    @Pattern(regexp = "^(MASCULINO|FEMENINO)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "El género debe ser 'MASCULINO' o 'FEMENINO'")
    private String pasGenero;

}
