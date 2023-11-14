package com.aerolinea.aerolinea.payload.Usuario;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorTpuId.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueTpuId {

    String message() default "El tipo de usuario ya se encuentra en uso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
