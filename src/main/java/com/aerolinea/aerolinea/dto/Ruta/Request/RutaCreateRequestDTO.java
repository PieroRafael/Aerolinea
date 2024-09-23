package com.aerolinea.aerolinea.dto.Ruta.Request;

import com.aerolinea.aerolinea.payload.Ruta.UniqueRtaNombre;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RutaCreateRequestDTO {

    @NotNull
    @NotBlank
    @UniqueRtaNombre
    private String rtaNombre;

    @NotNull
    @Min(120)
    @Max(4320)
    @Positive
    private Integer rtaPromedioMinutos;

}
