package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Avion.DTOToEntity;

import com.aerolinea.aerolinea.dto.Avion.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AvionCreateRequestDTO extends PropertyMap<CreateRequestDTO, Avion>{

        @Override
        protected void configure() {
            map().getMarca().setMarId(source.getMarId());
            map().getModelo().setModId(source.getModId());
        }

}
