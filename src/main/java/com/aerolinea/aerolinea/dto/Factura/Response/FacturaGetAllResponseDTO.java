package com.aerolinea.aerolinea.dto.Factura.Response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FacturaGetAllResponseDTO {

    private BigDecimal facCostoTotal;

    private BigDecimal facTotalImpuesto;

    private LocalDate facFecha;

    private String facCod;

}
