package com.aerolinea.aerolinea.payload.TipoUsuario;

import com.aerolinea.aerolinea.persistence.repository.Usuario.TipoUsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorTpuNombre implements ConstraintValidator<UniqueTpuNombre, String> {

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        return !tipoUsuarioRepository.findByTpuNombre(value).isPresent();
    }

}
