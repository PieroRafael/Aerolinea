package com.aerolinea.aerolinea.payload.Vuelo;

import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import com.aerolinea.aerolinea.persistence.repository.Vuelo.VueloRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKVuelo implements ConstraintValidator<ExistFKVuelo, Long> {

    @Autowired
    VueloRepository vueloRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Vuelo> findFKVuelo = vueloRepository.findById(value);
        if (!findFKVuelo.isPresent()) {
            return false;
        }
        return true;
    }

}
