package com.aerolinea.aerolinea.payload.Usuario;

import com.aerolinea.aerolinea.persistence.entity.Usuario.TipoUsuario;
import com.aerolinea.aerolinea.persistence.repository.Usuario.TipoUsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorFKTipoUsuario implements ConstraintValidator<FKTipoUsuario, Long> {

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<TipoUsuario> findFKTipoUsuario = tipoUsuarioRepository.findById(value);
        if (!findFKTipoUsuario.isPresent()) {
            return false;
        }
        return true;
    }

}
