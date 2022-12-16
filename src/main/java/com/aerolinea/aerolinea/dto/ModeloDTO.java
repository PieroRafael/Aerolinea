package com.aerolinea.aerolinea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Modelo.UniqueModNombre;

import lombok.Data;

@Data
public class ModeloDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @NotNull
    @Size(min = 7, max = 8)
    @UniqueModNombre
    private String modNombre;

}
