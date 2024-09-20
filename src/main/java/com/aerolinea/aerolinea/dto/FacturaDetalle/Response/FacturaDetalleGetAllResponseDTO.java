package com.aerolinea.aerolinea.dto.FacturaDetalle.Response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FacturaDetalleGetAllResponseDTO {


    private String fadCodeTicket;

    private BigDecimal fadCostoTicket;

    private BigDecimal fadDescuento;

    private String vueCod;

    private String facCod;

    private String clsNombre;

    private String astNombre;

    private String pasNombre;

    private String pasApellido;

}
