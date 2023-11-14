package com.aerolinea.aerolinea.payload.ClaseSocial;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorClsNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueCslNombre {

    String message() default "La clase social ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
