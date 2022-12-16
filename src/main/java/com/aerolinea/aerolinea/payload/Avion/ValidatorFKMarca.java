package com.aerolinea.aerolinea.payload.Avion;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.repository.MarcaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorFKMarca implements ConstraintValidator<FKMarca, Long> {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Marca> findFKMarca = marcaRepository.findById(value);
        if (!findFKMarca.isPresent()) {
            return false;
        }
        return true;
    }

}
