package pl.kondziet.springbackend.application.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoWhitespaceValidator implements ConstraintValidator<NoWhitespace, String> {

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code == null) {
            return true;
        }
        return !code.trim().contains(" ");
    }
}
