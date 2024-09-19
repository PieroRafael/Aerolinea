package com.aerolinea.aerolinea.dto.Modelo.Request;

import com.aerolinea.aerolinea.payload.Modelo.UniqueModNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateByIdRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueModNombre
    private String modNombre;

}
