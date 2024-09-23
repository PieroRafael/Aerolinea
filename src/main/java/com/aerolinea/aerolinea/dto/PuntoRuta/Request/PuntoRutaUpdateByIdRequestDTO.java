package com.aerolinea.aerolinea.dto.PuntoRuta.Request;

import com.aerolinea.aerolinea.payload.PuntoEscala.ExistFkPuntoEscala;
import com.aerolinea.aerolinea.payload.Ruta.ExistFKRuta;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PuntoRutaUpdateByIdRequestDTO {

    @NotNull
    @NotBlank
    // Validación
    private String ptrOrden;

    @NotNull
    @ExistFKRuta
    private Long rtaId;

    @NotNull
    @ExistFkPuntoEscala
    private Long pesId;

}
