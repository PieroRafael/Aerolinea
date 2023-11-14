package com.aerolinea.aerolinea.payload.CargoTripulante;

import com.aerolinea.aerolinea.persistence.repository.Tripulacion.CargoTripulanteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorCatNombre implements ConstraintValidator<UniqueCatNombre, String> {

    @Autowired
    CargoTripulanteRepository cargoTripulanteRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !cargoTripulanteRepository.findByCatNombre(value).isPresent();
    }

}
