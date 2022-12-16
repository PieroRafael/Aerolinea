package com.aerolinea.aerolinea.payload.Avion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.aerolinea.persistence.repository.AvionRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorAviRegistro implements ConstraintValidator<UniqueAviRegistro, String> {

    @Autowired
    AvionRepository avionRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !avionRepository.findByAviRegistro(value).isPresent();
    }

}
