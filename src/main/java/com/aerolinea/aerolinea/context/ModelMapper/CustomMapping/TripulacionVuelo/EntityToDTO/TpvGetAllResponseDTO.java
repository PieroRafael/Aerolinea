package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.TripulacionVuelo.EntityToDTO;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.Response.TripulacionVueloGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TpvGetAllResponseDTO extends PropertyMap<TripulacionVuelo, TripulacionVueloGetAllResponseDTO> {

        @Override
        protected void configure() {
            map().setTriNombre(source.getTripulacion().getTriNombre());
            map().setTriApellido(source.getTripulacion().getTriApellido());
            map().setTriCodigo(source.getTripulacion().getTriCodigo());
            map().setVueCod(source.getVuelo().getVueCod());
            map().setVueFHPartida(source.getVuelo().getVueFHPartida());
            map().setVueFHLlegada(source.getVuelo().getVueFHLlegada());
            map().setCatNombre(source.getTripulacion().getCargoTripulante().getCatNombre());
            map().setAviRegistro(source.getVuelo().getAvion().getAviRegistro());
            map().setRtaNombre(source.getVuelo().getRuta().getRtaNombre());
        }

}
