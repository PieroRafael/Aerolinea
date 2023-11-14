package com.aerolinea.aerolinea.payload.CargoTripulante;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorCatNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueCatNombre {

    String message() default "El cargo ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
