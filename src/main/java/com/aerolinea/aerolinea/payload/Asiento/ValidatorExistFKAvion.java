package com.aerolinea.aerolinea.payload.Asiento;

import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.aerolinea.aerolinea.persistence.repository.Avion.AvionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKAvion implements ConstraintValidator<ExistFKAvion, Long> {

    @Autowired
    AvionRepository avionRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Avion> findFKAvion = avionRepository.findById(value);
        if (!findFKAvion.isPresent()) {
            return false;
        }
        return true;
    }

}
