package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Tripulacion.DTOToEntity;

import com.aerolinea.aerolinea.dto.Tripulacion.Request.TripulacionCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TplCreateRequestDTO extends PropertyMap<TripulacionCreateRequestDTO, Tripulacion> {

        @Override
        protected void configure() {
            map().getCargoTripulante().setCatId(source.getCatId());
        }

}
