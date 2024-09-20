package com.aerolinea.aerolinea.dto.Factura.Response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FacturaCreateResponseDTO {

    private BigDecimal facCostoTotal;

    private BigDecimal facTotalImpuesto;

    private LocalDate facFecha;

}
