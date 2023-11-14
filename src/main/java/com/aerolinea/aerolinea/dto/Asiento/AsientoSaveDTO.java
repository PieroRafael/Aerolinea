package com.aerolinea.aerolinea.dto.Asiento;

import com.aerolinea.aerolinea.payload.Asiento.ExistFKAvion;
import com.aerolinea.aerolinea.payload.Asiento.ExistFKTipoAsiento;
import com.aerolinea.aerolinea.payload.Asiento.UniqueAstNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AsientoSaveDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @UniqueAstNombre
    private String astNombre;

    @NotNull
    @ExistFKAvion
    private Long aviId;

    @NotNull
    @ExistFKTipoAsiento
    private Long tpaId;
}
