package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Avion.EntityToDTO;

import com.aerolinea.aerolinea.dto.Avion.Response.AvionCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AviCreateResponseDTO extends PropertyMap<Avion, AvionCreateResponseDTO>{

        @Override
        protected void configure() {
            map().setMarId(source.getMarca().getMarId());
            map().setModId(source.getModelo().getModId());
        }

}
