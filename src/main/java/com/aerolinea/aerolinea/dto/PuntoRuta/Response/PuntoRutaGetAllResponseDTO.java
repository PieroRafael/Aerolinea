package com.aerolinea.aerolinea.dto.PuntoRuta.Response;

import lombok.Data;

@Data
public class PuntoRutaGetAllResponseDTO {

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
