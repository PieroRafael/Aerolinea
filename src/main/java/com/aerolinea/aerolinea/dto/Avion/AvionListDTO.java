package com.aerolinea.aerolinea.dto.Avion;

import java.io.Serializable;

import lombok.Data;

@Data
public class AvionListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aviRegistro;

    private int aviCantidadAsientos;

    private String marNombre;

    private String modNombre;

}
