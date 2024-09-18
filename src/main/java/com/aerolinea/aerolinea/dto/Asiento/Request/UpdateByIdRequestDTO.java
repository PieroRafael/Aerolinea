package com.aerolinea.aerolinea.dto.Asiento.Request;

import com.aerolinea.aerolinea.payload.Asiento.ExistFKAvion;
import com.aerolinea.aerolinea.payload.Asiento.ExistFKTipoAsiento;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    // Crear validación única
    private String astNombre;

    @NotNull
    @ExistFKAvion
    private Long aviId;

    @NotNull
    @ExistFKTipoAsiento
    private Long tpaId;

}
