package com.aerolinea.aerolinea.dto.FacturaDetalle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class FacturaDetalleListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
