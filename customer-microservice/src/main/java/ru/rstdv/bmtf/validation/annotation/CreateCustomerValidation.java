package ru.rstdv.bmtf.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.rstdv.bmtf.validation.validator.CreateCustomerValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = CreateCustomerValidator.class)
public @interface CreateCustomerValidation {

    String message() default "{first name must not be empty, " +
            "phone should begin with +[country code], " +
            "email's length should be between [5, 54] excluding postfix @gmail.com, " +
            "password must not be empty" +
            "}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
