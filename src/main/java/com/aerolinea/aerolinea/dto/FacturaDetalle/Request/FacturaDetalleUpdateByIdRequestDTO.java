package com.aerolinea.aerolinea.dto.FacturaDetalle.Request;

import com.aerolinea.aerolinea.payload.Asiento.ExistFKAsiento;
import com.aerolinea.aerolinea.payload.ClaseSocial.ExistFKClaseSocial;
import com.aerolinea.aerolinea.payload.Factura.ExistFKFactura;
import com.aerolinea.aerolinea.payload.Pasajero.ExistFKPasajero;
import com.aerolinea.aerolinea.payload.Vuelo.ExistFKVuelo;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class FacturaDetalleUpdateByIdRequestDTO {

    @NotNull
    @Positive
    private BigDecimal fadCostoTicket;

    @Min(0)
    private BigDecimal fadDescuento;

    @NotNull
    @ExistFKVuelo
    //Validación
    private Long vueId;

    @NotNull
    @ExistFKClaseSocial
    private Long clsId;

    @NotNull
    @ExistFKAsiento
    private Long astId;

    @NotNull
    @ExistFKPasajero
    private Long pasId;

    @NotNull
    @ExistFKFactura
    //Validación
    private Long facId;

}
