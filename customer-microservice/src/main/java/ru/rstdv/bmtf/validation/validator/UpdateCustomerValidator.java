package ru.rstdv.bmtf.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;

import ru.rstdv.bmtf.validation.annotation.UpdateCustomerValidation;

public class UpdateCustomerValidator implements ConstraintValidator<UpdateCustomerValidation, CreateUpdateCustomerDto> {
    @Override
    public boolean isValid(CreateUpdateCustomerDto value, ConstraintValidatorContext context) {
        return true;
    }
}
