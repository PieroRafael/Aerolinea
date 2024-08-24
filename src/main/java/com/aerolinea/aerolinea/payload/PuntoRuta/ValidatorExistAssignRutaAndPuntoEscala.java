package com.aerolinea.aerolinea.payload.PuntoRuta;

import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaSaveDTO;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoRutaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@Log4j2
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidatorExistAssignRutaAndPuntoEscala implements ConstraintValidator<ExistAssignRutaAndPuntoEscala,Object[]> {

    @Autowired
    PuntoRutaRepository puntoRutaRepository;

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        Long rtaId;
        Long pesId;
        PuntoRutaSaveDTO puntoRutaSaveDTO = null;
        if(objects[0] instanceof PuntoRutaSaveDTO){
            puntoRutaSaveDTO = (PuntoRutaSaveDTO) objects[0];
        }
        rtaId = puntoRutaSaveDTO.getRtaId();
        pesId = puntoRutaSaveDTO.getPesId();
        var rx = puntoRutaRepository.findByRutaAndPuntoEscala(
                Ruta.builder().rtaId(rtaId).build(),PuntoEscala.builder().pesId(pesId).build()
        );
        return rx.isPresent();
    }

}
