package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Vuelo.DTOToEntity;

import com.aerolinea.aerolinea.dto.Vuelo.Request.VueloCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class VueCreateRequestDTO extends PropertyMap<VueloCreateRequestDTO, Vuelo> {

        @Override
        protected void configure() {
            map().getAvion().setAviId(source.getAviId());
            map().getRuta().setRtaId(source.getRtaId());
        }

}
