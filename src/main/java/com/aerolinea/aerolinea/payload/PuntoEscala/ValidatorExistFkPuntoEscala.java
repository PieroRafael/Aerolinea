package com.aerolinea.aerolinea.payload.PuntoEscala;

import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoEscalaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFkPuntoEscala implements ConstraintValidator<ExistFkPuntoEscala, Long> {

    @Autowired
    PuntoEscalaRepository puntoEscalaRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<PuntoEscala> findFKPuntoEscala = puntoEscalaRepository.findById(value);
        if (!findFKPuntoEscala.isPresent()) {
            return false;
        }
        return true;
    }

}
