package com.aerolinea.aerolinea.payload.PuntoEscala;

import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoEscalaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorPesNombrePunto implements ConstraintValidator<UniquePesNombrePunto,String> {

    @Autowired
    PuntoEscalaRepository puntoEscalaRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !puntoEscalaRepository.findByPesNombrePunto(value).isPresent();
    }

}
