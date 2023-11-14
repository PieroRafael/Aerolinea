package com.aerolinea.aerolinea.payload.Usuario;

import com.aerolinea.aerolinea.persistence.repository.Usuario.UsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Log4j2
public class ValidatorTpuId implements ConstraintValidator<UniqueTpuId , Long> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !usuarioRepository.existsById(value);
    }

}
