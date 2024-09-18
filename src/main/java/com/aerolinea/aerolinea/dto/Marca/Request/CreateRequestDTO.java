package com.aerolinea.aerolinea.dto.Marca.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Marca.UniqueMarNombre;

import lombok.Data;

@Data
public class CreateRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueMarNombre
    private String marNombre;

}
