package com.aerolinea.aerolinea.payload.Ruta;

import com.aerolinea.aerolinea.persistence.repository.Ruta.RutaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorRtaNombre implements ConstraintValidator<UniqueRtaNombre,String> {

    @Autowired
    RutaRepository rutaRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !rutaRepository.findByRtaNombre(value).isPresent();
    }

}
