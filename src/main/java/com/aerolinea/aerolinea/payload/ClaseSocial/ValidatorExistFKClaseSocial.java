package com.aerolinea.aerolinea.payload.ClaseSocial;

import com.aerolinea.aerolinea.persistence.entity.Factura.ClaseSocial;
import com.aerolinea.aerolinea.persistence.repository.Factura.ClaseSocialRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKClaseSocial implements ConstraintValidator<ExistFKClaseSocial, Long> {

    @Autowired
    ClaseSocialRepository claseSocialRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<ClaseSocial> findFKClaseSocial = claseSocialRepository.findById(value);
        if (!findFKClaseSocial.isPresent()) {
            return false;
        }
        return true;
    }

}
