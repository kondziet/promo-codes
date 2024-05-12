package pl.kondziet.springbackend.application.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoWhitespaceValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWhitespace {
    String message() default "Code cannot contain whitespace characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
