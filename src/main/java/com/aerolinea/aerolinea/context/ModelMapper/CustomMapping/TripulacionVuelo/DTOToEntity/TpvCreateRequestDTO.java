package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.TripulacionVuelo.DTOToEntity;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.Request.TripulacionVueloCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TpvCreateRequestDTO extends PropertyMap<TripulacionVueloCreateRequestDTO, TripulacionVuelo> {

        @Override
        protected void configure() {
            map().getTripulacion().setTriId(source.getTriId());
            map().getVuelo().setVueId(source.getVueId());
        }

}
