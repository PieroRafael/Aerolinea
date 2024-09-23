package com.aerolinea.aerolinea.dto.Ruta.Request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RutaUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    // Validación
    private String rtaNombre;

    @NotNull
    @Min(120)
    @Max(4320)
    @Positive
    private Integer rtaPromedioMinutos;

}
