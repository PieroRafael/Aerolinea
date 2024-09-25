package com.aerolinea.aerolinea.context.ModelMapper.CustomMapping.Tripulacion.EntityToDTO;

import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionCreateResponseDTO;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TplCreateResponseDTO extends PropertyMap<Tripulacion, TripulacionCreateResponseDTO> {

        @Override
        protected void configure() {
            map().setCatId(source.getCargoTripulante().getCatId());
        }

}
