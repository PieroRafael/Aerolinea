package com.aerolinea.aerolinea.dto.Avion.Request;

import com.aerolinea.aerolinea.payload.Avion.FKMarca;
import com.aerolinea.aerolinea.payload.Avion.FKModelo;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateByIdRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 7, max = 8)
    // Crear validación única
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
