package com.example.cinema.models.utils.validators;

import com.example.cinema.models.utils.errors.InvalidPasswordError;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
    public void validate(String password) {
        if(!"super_secret".equals(password)) {
            throw new InvalidPasswordError("The password is wrong!");
        }
    }
}
