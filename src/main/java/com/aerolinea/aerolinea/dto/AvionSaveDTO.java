package com.aerolinea.aerolinea.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private int aviCantidadAsientos;

    @NotNull
    @FKMarca
    private Long marId;

    @NotNull
    @FKModelo
    private Long modId;

}
