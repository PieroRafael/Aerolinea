package com.aerolinea.aerolinea.payload.Tripulacion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorTriApellido.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueTriApellido {

    String message() default "El apellido ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
