package com.aerolinea.aerolinea.dto.FacturaDetalle.Response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FacturaDetalleCreateResponseDTO {

    private BigDecimal fadCostoTicket;

    private BigDecimal fadDescuento;

    private Long vueId;

    private Long clsId;

    private Long astId;

    private Long pasId;

    private Long facId;

}
