package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.PuntoRuta.DTOToEntity;

import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PtrUpdateByIdRequestDTO extends PropertyMap<PuntoRutaUpdateByIdRequestDTO, PuntoRuta> {

    @Override
    protected void configure() {
        map().getRuta().setRtaId(source.getRtaId());
        map().getPuntoEscala().setPesId(source.getPesId());
    }

}
