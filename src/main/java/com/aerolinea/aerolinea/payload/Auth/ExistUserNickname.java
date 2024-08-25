package com.aerolinea.aerolinea.payload.Auth;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorExistUserNickname.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExistUserNickname {

    String message() default "Nickname Incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}