package ru.rstdv.bmtf.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.rstdv.bmtf.validation.validator.UpdateCustomerValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UpdateCustomerValidator.class)
public @interface UpdateCustomerValidation {
    String message() default "{all address's fields must be filled in}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
