package com.aerolinea.aerolinea.dto.Ruta;

import com.aerolinea.aerolinea.payload.Ruta.UniqueRtaNombre;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class RutaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
