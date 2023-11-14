package com.aerolinea.aerolinea.dto.PuntoRuta;

import com.aerolinea.aerolinea.payload.PuntoEscala.ExistFkPuntoEscala;
import com.aerolinea.aerolinea.payload.PuntoRuta.UniquePtrOrden;
import com.aerolinea.aerolinea.payload.Ruta.ExistFKRuta;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PuntoRutaSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @UniquePtrOrden
    private String ptrOrden;

    @NotNull
    @ExistFKRuta
    private Long rtaId;

    @NotNull
    @ExistFkPuntoEscala
    private Long pesId;

}
