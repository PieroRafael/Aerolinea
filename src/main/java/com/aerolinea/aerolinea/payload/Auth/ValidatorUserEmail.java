package com.aerolinea.aerolinea.payload.Auth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aerolinea.aerolinea.persistence.repository.Auth.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;



import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidatorUserEmail implements ConstraintValidator<UniqueUserEmail, String> {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("Running is Valid");
        return !usersRepository.findByUserEmail(value).isPresent();
    }

}
