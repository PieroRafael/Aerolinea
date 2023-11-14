package com.aerolinea.aerolinea.payload.Ruta;

import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.repository.Ruta.RutaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKRuta implements ConstraintValidator<ExistFKRuta, Long> {

    @Autowired
    RutaRepository rutaRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context){
        log.info("running is Valid");
        Optional<Ruta> findFKRuta = rutaRepository.findById(value);
        if (!findFKRuta.isPresent()) {
            return false;
        }
        return true;
    }

}
