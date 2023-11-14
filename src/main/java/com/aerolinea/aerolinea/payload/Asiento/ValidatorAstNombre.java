package com.aerolinea.aerolinea.payload.Asiento;

import com.aerolinea.aerolinea.persistence.repository.Avion.AsientoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorAstNombre implements ConstraintValidator<UniqueAstNombre, String> {

    @Autowired
    AsientoRepository asientoRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !asientoRepository.findByAstNombre(value).isPresent();
    }

}
