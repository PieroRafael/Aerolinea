package com.aerolinea.aerolinea.payload.Asiento;

import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import com.aerolinea.aerolinea.persistence.repository.Avion.AsientoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKAsiento implements ConstraintValidator<ExistFKAsiento, Long> {

    @Autowired
    AsientoRepository asientoRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Asiento> findFKAsiento = asientoRepository.findById(value);
        if (!findFKAsiento.isPresent()) {
            return false;
        }
        return true;
    }

}
