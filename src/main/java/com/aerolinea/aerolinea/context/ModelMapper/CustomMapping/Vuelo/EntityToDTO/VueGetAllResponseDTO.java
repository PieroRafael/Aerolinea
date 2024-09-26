package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Vuelo.EntityToDTO;

import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class VueGetAllResponseDTO extends PropertyMap<Vuelo, VueloGetAllResponseDTO> {

        @Override
        protected void configure() {
            map().setAviRegistro(source.getAvion().getAviRegistro());
            map().setRtaNombre(source.getRuta().getRtaNombre());
        }

}
