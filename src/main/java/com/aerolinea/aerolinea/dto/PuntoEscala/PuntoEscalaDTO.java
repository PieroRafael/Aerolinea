package com.aerolinea.aerolinea.dto.PuntoEscala;

import com.aerolinea.aerolinea.payload.PuntoEscala.UniquePesNombrePunto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PuntoEscalaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @UniquePesNombrePunto
    private String pesNombrePunto;

    @NotNull
    private Double pesLongitud;

    @NotNull
    private Double pesLatitud;

}
