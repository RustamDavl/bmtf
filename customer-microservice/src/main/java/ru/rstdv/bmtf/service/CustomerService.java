package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.entity.Customer;
import ru.rstdv.bmtf.exception.CustomerNotFoundException;
import ru.rstdv.bmtf.mapper.CustomerMapper;
import ru.rstdv.bmtf.repository.CustomerRepository;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements IService<ReadCustomerDto, CreateUpdateCustomerDto> {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapperImpl;

    @Override
    public ReadCustomerDto create(CreateUpdateCustomerDto createUpdateDto) {
        return customerMapperImpl.toReadCustomerDto(
                customerRepository.save(customerMapperImpl.toCustomer(createUpdateDto))
        );
    }

    @Override
    public boolean delete(Long id) {
        var maybeCustomer = customerRepository.findById(id);

        if (maybeCustomer.isPresent()) {
            customerRepository.delete(maybeCustomer.get());
            return true;
        } else
            return false;

    }

    @Override
    public ReadCustomerDto update(Long id, CreateUpdateCustomerDto createUpdateDto) {

        var currentCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("there is no entity with such id : " + id));

        return customerMapperImpl.toReadCustomerDto(
                customerMapperImpl.updateCustomerFromDto(currentCustomer, createUpdateDto)
        );


    }

    @Override
    public ReadCustomerDto find(Long id) {
        return customerRepository.findById(id)
                .map(customerMapperImpl::toReadCustomerDto)
                .orElseThrow(() -> new CustomerNotFoundException("there is no entity with such id : " + id));
    }

}
