package com.aerolinea.aerolinea.dto.TipoAsiento.Request;

import com.aerolinea.aerolinea.payload.TipoAsiento.UniqueTpaNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TipoAsientoCreateRequestDTO {

    @NotBlank
    @NotNull
    @Size(min =  5, max = 15)
    @UniqueTpaNombre
    private String tpaNombre;

}
