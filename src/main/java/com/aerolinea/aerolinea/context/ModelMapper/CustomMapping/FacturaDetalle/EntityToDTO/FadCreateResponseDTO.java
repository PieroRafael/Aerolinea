package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.FacturaDetalle.EntityToDTO;

import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class FadCreateResponseDTO extends PropertyMap<FacturaDetalle, FacturaDetalleCreateResponseDTO> {

        @Override
        protected void configure() {
            map().setFadCostoTicket(source.getFadCostoTicket());
            map().setFadDescuento(source.getFadDescuento());
            map().setVueId(source.getVuelo().getVueId());
            map().setClsId(source.getClaseSocial().getClsId());
            map().setAstId(source.getAsiento().getAstId());
            map().setPasId(source.getPasajero().getPasId());
            map().setFacId(source.getFactura().getFacId());
        }

}


