package com.aerolinea.aerolinea.dto.Asiento;

import lombok.Data;

import java.io.Serializable;

@Data
public class AsientoListDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String astNombre;

    private String aviRegistro;

    private String tpaNombre;

}
