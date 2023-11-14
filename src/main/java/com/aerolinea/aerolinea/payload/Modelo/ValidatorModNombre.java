package com.aerolinea.aerolinea.payload.Modelo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.aerolinea.persistence.repository.Avion.ModeloRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorModNombre implements ConstraintValidator<UniqueModNombre, String> {

    @Autowired
    ModeloRepository modeloRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !modeloRepository.findByModNombre(value).isPresent();
    }

}
