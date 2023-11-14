package com.aerolinea.aerolinea.dto.PuntoRuta;

import lombok.Data;

import java.io.Serializable;

@Data
public class PuntoRutaListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // Punto Ruta

    private String ptrOrden;

    // Ruta

    private String rtaNombre;

    private Integer rtaPromedioMinutos;

    // PuntoEscala

    private String pesNombrePunto;

    private Double pesLongitud;

    private Double pesLatitud;

}
