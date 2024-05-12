package pl.kondziet.springbackend.application.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimmedSizeValidator implements ConstraintValidator<TrimmedSize, String> {

    private int min;
    private int max;

    @Override
    public void initialize(TrimmedSize constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code == null) {
            return true;
        }

        String trimmedValue = code.trim();
        int trimmedSize = trimmedValue.length();
        return trimmedSize >= min && trimmedSize <= max;
    }
}
