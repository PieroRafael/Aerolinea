package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Avion.EntityToDTO;

import com.aerolinea.aerolinea.dto.Avion.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AvionCreateResponseDTO extends PropertyMap<Avion, CreateResponseDTO>{

        @Override
        protected void configure() {
            map().setMarId(source.getMarca().getMarId());
            map().setModId(source.getModelo().getModId());
        }

}
