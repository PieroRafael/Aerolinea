package com.aerolinea.aerolinea.payload.TipoAsiento;

import com.aerolinea.aerolinea.persistence.repository.Avion.TipoAsientoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorTpaNombre implements ConstraintValidator<UniqueTpaNombre, String> {

    @Autowired
    TipoAsientoRepository tipoAsientoRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !tipoAsientoRepository.findByTpaNombre(value).isPresent();
    }

}
