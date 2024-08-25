package com.aerolinea.aerolinea.payload.Auth;

import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Auth.Users;
import com.aerolinea.aerolinea.persistence.repository.Auth.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class ValidatorExistPassword implements ConstraintValidator<ExistPassword, String> {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("Running is Valid");
        return usersRepository.findByUserPassword(value).isPresent();
    }

}
