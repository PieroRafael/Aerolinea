package com.aerolinea.aerolinea.dto.Avion.Request;

import javax.validation.constraints.*;

import com.aerolinea.aerolinea.payload.Avion.FKMarca;
import com.aerolinea.aerolinea.payload.Avion.FKModelo;
import com.aerolinea.aerolinea.payload.Avion.UniqueAviRegistro;

import lombok.Data;

@Data
public class AvionCreateRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 7, max = 8)
    @UniqueAviRegistro
    private String aviRegistro;

    @NotNull
    @Min(20)
    @Max(60)
    @Positive
    private int aviCantidadAsientos;

    @NotNull
    @FKMarca
    private Long marId;

    @NotNull
    @FKModelo
    private Long modId;

}
