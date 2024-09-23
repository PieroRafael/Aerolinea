package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.PuntoRuta.EntityToDTO;

import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PtrCreateResponseDTO extends PropertyMap<PuntoRuta, PuntoRutaCreateResponseDTO> {

        @Override
        protected void configure() {
            map().setRtaId(source.getRuta().getRtaId());
            map().setPesId(source.getPuntoEscala().getPesId());
        }

}
