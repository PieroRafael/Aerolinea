package com.aerolinea.aerolinea.payload.CargoTripulante;

import com.aerolinea.aerolinea.persistence.entity.Tripulacion.CargoTripulante;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.CargoTripulanteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKCargoTripulante implements ConstraintValidator<ExistFKCargoTripulante, Long> {

    @Autowired
    CargoTripulanteRepository cargoTripulanteRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<CargoTripulante> findFKCargoTripulante = cargoTripulanteRepository.findById(value);
        if (!findFKCargoTripulante.isPresent()) {
            return false;
        }
        return true;
    }

}
