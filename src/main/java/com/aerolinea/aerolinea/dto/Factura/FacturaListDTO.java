package com.aerolinea.aerolinea.dto.Factura;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class FacturaListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal facCostoTotal;

    private BigDecimal facTotalImpuesto;

    private LocalDate facFecha;

    private UUID facCod;

}
