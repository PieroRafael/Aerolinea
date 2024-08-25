package com.aerolinea.aerolinea.payload.Auth;

import com.aerolinea.aerolinea.persistence.repository.Auth.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorExistUserNickname implements ConstraintValidator<ExistUserNickname, String> {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("Running is Valid");
        return usersRepository.findByUserNickname(value).isPresent();
    }

}
