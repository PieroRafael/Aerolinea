package com.aerolinea.aerolinea.payload.Asiento;

import com.aerolinea.aerolinea.persistence.entity.Avion.TipoAsiento;
import com.aerolinea.aerolinea.persistence.repository.Avion.TipoAsientoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKTipoAsiento implements ConstraintValidator<ExistFKTipoAsiento , Long> {

    @Autowired
    TipoAsientoRepository tipoAsientoRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<TipoAsiento> findFKTipoAsiento = tipoAsientoRepository.findById(value);
        if (!findFKTipoAsiento.isPresent()) {
            return false;
        }
        return true;
    }

}
