package ru.rstdv.bmtf.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.validation.annotation.CreateCustomerValidation;

public class CreateCustomerValidator implements ConstraintValidator<CreateCustomerValidation, CreateUpdateCustomerDto> {

    @Override
    public boolean isValid(CreateUpdateCustomerDto createUpdateCustomerDto, ConstraintValidatorContext constraintValidatorContext) {

        return StringUtils.hasText(createUpdateCustomerDto.firstName()) &&
                createUpdateCustomerDto.phone().matches("\\+7\\d{10}") &&
                createUpdateCustomerDto.email().matches("[a-zA-Z0-9]{5,54}@gmail.com") &&
                StringUtils.hasText(createUpdateCustomerDto.password());


    }
}
