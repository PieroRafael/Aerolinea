package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Vuelo.EntityToDTO;

import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class VueCreateResponseDTO extends PropertyMap<Vuelo, VueloCreateResponseDTO> {

        @Override
        protected void configure() {
            map().setAviId(source.getAvion().getAviId());
            map().setRtaId(source.getRuta().getRtaId());
        }

}
