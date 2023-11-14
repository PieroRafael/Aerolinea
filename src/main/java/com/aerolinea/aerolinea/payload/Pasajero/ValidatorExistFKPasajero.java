package com.aerolinea.aerolinea.payload.Pasajero;

import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import com.aerolinea.aerolinea.persistence.repository.Pasajero.PasajeroRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKPasajero implements ConstraintValidator<ExistFKPasajero, Long> {

    @Autowired
    PasajeroRepository pasajeroRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Pasajero> findFKPasajero = pasajeroRepository.findById(value);
        if (!findFKPasajero.isPresent()) {
            return false;
        }
        return true;
    }

}

