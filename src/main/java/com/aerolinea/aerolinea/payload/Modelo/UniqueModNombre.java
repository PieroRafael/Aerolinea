package com.aerolinea.aerolinea.payload.Modelo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidatorModNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueModNombre {

    String message() default "El nombre ya está en uso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
