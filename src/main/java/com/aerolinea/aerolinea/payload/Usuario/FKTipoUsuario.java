package com.aerolinea.aerolinea.payload.Usuario;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorFKTipoUsuario.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FKTipoUsuario {

    String message() default "El valor no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
