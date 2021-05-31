package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({
        FIELD,
        METHOD
})
@Constraint(validatedBy = StartWithValidator.class)
public @interface StartWith {

    String value();

    String message() default "StartWith check failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}