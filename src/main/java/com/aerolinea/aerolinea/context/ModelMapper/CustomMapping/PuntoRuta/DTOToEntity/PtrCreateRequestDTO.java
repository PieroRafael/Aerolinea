package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.PuntoRuta.DTOToEntity;

import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PtrCreateRequestDTO extends PropertyMap<PuntoRutaCreateRequestDTO, PuntoRuta> {

        @Override
        protected void configure() {
            map().getRuta().setRtaId(source.getRtaId());
            map().getPuntoEscala().setPesId(source.getPesId());
        }

}


