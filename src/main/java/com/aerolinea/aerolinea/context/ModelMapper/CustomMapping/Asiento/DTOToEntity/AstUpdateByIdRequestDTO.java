package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Asiento.DTOToEntity;

import com.aerolinea.aerolinea.dto.Asiento.Request.AsientoUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AstUpdateByIdRequestDTO extends PropertyMap<AsientoUpdateByIdRequestDTO, Asiento> {

    @Override
    protected void configure() {
        map().getTipoAsiento().setTpaId(source.getTpaId());
        map().getAvion().setAviId(source.getAviId());
    }

}
