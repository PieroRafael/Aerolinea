package com.aerolinea.aerolinea.dto.ClaseSocial.Request;

import com.aerolinea.aerolinea.payload.ClaseSocial.UniqueCslNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    @UniqueCslNombre
    private String clsNombre;

}
