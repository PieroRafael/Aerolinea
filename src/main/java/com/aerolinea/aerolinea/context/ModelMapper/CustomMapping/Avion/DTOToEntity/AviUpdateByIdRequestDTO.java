package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Avion.DTOToEntity;

import com.aerolinea.aerolinea.dto.Avion.Request.AvionUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AviUpdateByIdRequestDTO extends PropertyMap<AvionUpdateByIdRequestDTO, Avion> {

    @Override
    protected void configure() {
        map().getMarca().setMarId(source.getMarId());
        map().getModelo().setModId(source.getModId());
    }

}
