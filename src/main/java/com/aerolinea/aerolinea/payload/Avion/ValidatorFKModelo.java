package com.aerolinea.aerolinea.payload.Avion;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.aerolinea.persistence.entity.Avion.Modelo;
import com.aerolinea.aerolinea.persistence.repository.Avion.ModeloRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorFKModelo implements ConstraintValidator<FKModelo, Long> {

    @Autowired
    ModeloRepository modeloRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Modelo> findFKModelo = modeloRepository.findById(value);
        if (!findFKModelo.isPresent()) {
            return false;
        }
        return true;
    }

}
