package com.aerolinea.aerolinea.dto.Marca.Request;

import com.aerolinea.aerolinea.payload.Marca.UniqueMarNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateByIdRequestDTO {

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueMarNombre
    private String marNombre;

}
