package com.aerolinea.aerolinea.payload.ClaseSocial;

import com.aerolinea.aerolinea.persistence.repository.Factura.ClaseSocialRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorClsNombre implements ConstraintValidator<UniqueCslNombre, String> {

    @Autowired
    ClaseSocialRepository claseSocialRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !claseSocialRepository.findByClsNombre(value).isPresent();
    }

}
