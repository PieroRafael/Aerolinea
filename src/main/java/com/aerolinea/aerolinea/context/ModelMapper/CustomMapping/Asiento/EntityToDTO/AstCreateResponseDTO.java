package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Asiento.EntityToDTO;

import com.aerolinea.aerolinea.dto.Asiento.Response.AsientoCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class AstCreateResponseDTO extends PropertyMap<Asiento, AsientoCreateResponseDTO>{

        @Override
        protected void configure() {
            map().setAviId(source.getAvion().getAviId());
            map().setTpaId(source.getTipoAsiento().getTpaId());
        }

}


