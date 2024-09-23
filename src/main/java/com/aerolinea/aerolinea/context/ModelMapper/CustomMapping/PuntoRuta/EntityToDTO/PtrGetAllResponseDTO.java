package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.PuntoRuta.EntityToDTO;

import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PtrGetAllResponseDTO extends PropertyMap<PuntoRuta, PuntoRutaGetAllResponseDTO> {

        @Override
        protected void configure() {
            map().setRtaNombre(source.getRuta().getRtaNombre());
            map().setRtaPromedioMinutos(source.getRuta().getRtaPromedioMinutos());
            map().setPesNombrePunto(source.getPuntoEscala().getPesNombrePunto());
            map().setPesLongitud(source.getPuntoEscala().getPesLongitud());
            map().setPesLatitud(source.getPuntoEscala().getPesLatitud());
        }

}
