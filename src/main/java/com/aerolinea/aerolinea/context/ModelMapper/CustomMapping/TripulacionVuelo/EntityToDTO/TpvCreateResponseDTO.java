package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.TripulacionVuelo.EntityToDTO;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.Response.TripulacionVueloCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TpvCreateResponseDTO extends PropertyMap<TripulacionVuelo, TripulacionVueloCreateResponseDTO> {

        @Override
        protected void configure() {
            map().setVueId(source.getVuelo().getVueId());
            map().setTriId(source.getTripulacion().getTriId());
        }

}
