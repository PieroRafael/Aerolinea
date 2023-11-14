package com.aerolinea.aerolinea.dto.Factura;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FacturaSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal facCostoTotal;

    @NotNull
    private BigDecimal facTotalImpuesto;

    @NotNull
    private LocalDate facFecha;

}
