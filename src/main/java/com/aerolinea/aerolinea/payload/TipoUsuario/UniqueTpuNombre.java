package com.aerolinea.aerolinea.payload.TipoUsuario;

import com.aerolinea.aerolinea.payload.Modelo.ValidatorModNombre;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorTpuNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueTpuNombre {

    String message() default "El nombre ya está en uso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
