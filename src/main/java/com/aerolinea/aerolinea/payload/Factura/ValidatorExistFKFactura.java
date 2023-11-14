package com.aerolinea.aerolinea.payload.Factura;

import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import com.aerolinea.aerolinea.persistence.repository.Factura.FacturaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Log4j2
public class ValidatorExistFKFactura implements ConstraintValidator<ExistFKFactura, Long> {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        log.info("running is Valid");
        Optional<Factura> findFKFactura = facturaRepository.findById(value);
        if (!findFKFactura.isPresent()) {
            return false;
        }
        return true;
    }

}
