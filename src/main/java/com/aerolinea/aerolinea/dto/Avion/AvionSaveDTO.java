package com.aerolinea.aerolinea.dto.Avion;

import javax.validation.constraints.*;

import com.aerolinea.aerolinea.payload.Avion.FKMarca;
import com.aerolinea.aerolinea.payload.Avion.FKModelo;
import com.aerolinea.aerolinea.payload.Avion.UniqueAviRegistro;

import java.io.Serializable;

import lombok.Data;

@Data
public class AvionSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
