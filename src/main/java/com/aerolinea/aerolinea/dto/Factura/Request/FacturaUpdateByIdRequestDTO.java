package com.aerolinea.aerolinea.dto.Factura.Request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FacturaUpdateByIdRequestDTO {

    @NotNull
    private BigDecimal facCostoTotal;

    @NotNull
    private BigDecimal facTotalImpuesto;

    @NotNull
    private LocalDate facFecha;

}
