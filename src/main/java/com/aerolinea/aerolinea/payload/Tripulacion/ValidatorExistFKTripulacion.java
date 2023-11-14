package com.aerolinea.aerolinea.payload.Tripulacion;

import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.TripulacionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKTripulacion implements ConstraintValidator<ExistFKTripulacion, Long> {

    @Autowired
    TripulacionRepository tripulacionRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Tripulacion> findFKTripulacion = tripulacionRepository.findById(value);
        if (!findFKTripulacion.isPresent()) {
            return false;
        }
        return true;
    }

}
