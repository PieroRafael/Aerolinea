package com.aerolinea.aerolinea.payload.Pasajero;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorExistFKPasajero.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExistFKPasajero {

    String message() default "El valor no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
