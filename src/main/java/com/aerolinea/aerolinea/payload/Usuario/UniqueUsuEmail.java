package com.aerolinea.aerolinea.payload.Usuario;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorUsuEmail.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueUsuEmail {

    String message() default "El email ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
