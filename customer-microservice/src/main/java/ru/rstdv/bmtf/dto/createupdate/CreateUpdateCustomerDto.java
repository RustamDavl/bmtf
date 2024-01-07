package ru.rstdv.bmtf.dto.createupdate;


import ru.rstdv.bmtf.validation.annotation.CreateCustomerValidation;
import ru.rstdv.bmtf.validation.group.OnCreateAction;

@CreateCustomerValidation(groups = OnCreateAction.class)
public record CreateUpdateCustomerDto(String firstName, String phone, String email, String password) {
}
