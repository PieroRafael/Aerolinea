package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.FacturaDetalle.EntityToDTO;

import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class FadGetAllResponseDTO extends PropertyMap<FacturaDetalle, FacturaDetalleGetAllResponseDTO> {

    @Override
    protected void configure() {
        map().setFadCodeTicket(source.getFadCodeTicket());
        map().setFadCostoTicket(source.getFadCostoTicket());
        map().setFadDescuento(source.getFadDescuento());
        map().setVueCod(source.getVuelo().getVueCod());
        map().setFacCod(source.getFactura().getFacCod());
        map().setClsNombre(source.getClaseSocial().getClsNombre());
        map().setAstNombre(source.getAsiento().getAstNombre());
        map().setPasNombre(source.getPasajero().getPasNombre());
        map().setPasApellido(source.getPasajero().getPasApellido());

    }

}
