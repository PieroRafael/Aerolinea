package com.aerolinea.aerolinea.payload.Pasajero;

import com.aerolinea.aerolinea.persistence.repository.Pasajero.PasajeroRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorPasNombre implements ConstraintValidator<UniquePasNombre, String> {

    @Autowired
    PasajeroRepository pasajeroRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !pasajeroRepository.findByPasNombre(value).isPresent();
    }

}
