package com.aerolinea.aerolinea.payload.Pasajero;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorPasNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniquePasNombre {

    String message() default "El nombre ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
