package com.aerolinea.aerolinea.payload.Tripulacion;

import com.aerolinea.aerolinea.persistence.repository.Tripulacion.TripulacionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorTriApellido implements ConstraintValidator<UniqueTriApellido, String> {

    @Autowired
    TripulacionRepository tripulacionRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !tripulacionRepository.findByTriApellido(value).isPresent();
    }

}
