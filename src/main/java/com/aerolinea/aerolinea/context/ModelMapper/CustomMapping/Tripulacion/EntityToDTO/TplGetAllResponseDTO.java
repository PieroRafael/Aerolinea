package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Tripulacion.EntityToDTO;

import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionGetAllResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TplGetAllResponseDTO extends PropertyMap<Tripulacion, TripulacionGetAllResponseDTO> {

        @Override
        protected void configure() {
            map().setCatNombre(source.getCargoTripulante().getCatNombre());
        }

}
