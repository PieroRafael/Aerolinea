package com.aerolinea.aerolinea.dto.Modelo.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Modelo.UniqueModNombre;

import lombok.Data;

@Data
public class ModeloCreateRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueModNombre
    private String modNombre;

}
