package pl.kondziet.springbackend.application.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TrimmedSizeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TrimmedSize {
    String message() default "Trimmed code has to be 3-24 characters long";
    int min() default 3;
    int max() default 24;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
