package com.aerolinea.aerolinea.payload.Avion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidatorAviRegistro.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueAviRegistro {

    String message() default "El registro ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
