package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.FacturaDetalle.DTOToEntity;

import com.aerolinea.aerolinea.dto.FacturaDetalle.Request.FacturaDetalleCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class FadCreateRequestDTO extends PropertyMap<FacturaDetalleCreateRequestDTO, FacturaDetalle> {

        @Override
        protected void configure() {
            map().getAsiento().setAstId(source.getAstId());
            map().getClaseSocial().setClsId(source.getClsId());
            map().getVuelo().setVueId(source.getVueId());
            map().getPasajero().setPasId(source.getPasId());
            map().getFactura().setFacId(source.getFacId());
        }

}
