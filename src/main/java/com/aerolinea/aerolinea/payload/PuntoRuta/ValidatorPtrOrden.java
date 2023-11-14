package com.aerolinea.aerolinea.payload.PuntoRuta;

import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoRutaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorPtrOrden implements ConstraintValidator<UniquePtrOrden,String> {

    @Autowired
    PuntoRutaRepository puntoRutaRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !puntoRutaRepository.findByPtrOrden(value).isPresent();
    }

}
