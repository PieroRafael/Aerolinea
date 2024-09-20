package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Avion.EntityToDTO;

import com.aerolinea.aerolinea.dto.Avion.Response.AvionGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AviGetAllResponseDTO extends PropertyMap<Avion, AvionGetAllResponseDTO> {

        @Override
        protected void configure() {
            map().setMarNombre(source.getMarca().getMarNombre());
            map().setModNombre(source.getModelo().getModNombre());
        }

}
