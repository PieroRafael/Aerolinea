package com.aerolinea.aerolinea.payload.Marca;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.aerolinea.persistence.repository.Avion.MarcaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorMarNombre implements ConstraintValidator<UniqueMarNombre, String> {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !marcaRepository.findByMarNombre(value).isPresent();
    }

}
