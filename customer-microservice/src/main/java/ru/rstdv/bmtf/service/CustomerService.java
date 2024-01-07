package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.exception.CustomerNotFoundException;
import ru.rstdv.bmtf.mapper.CustomerMapper;
import ru.rstdv.bmtf.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements IService<ReadCustomerDto, CreateUpdateCustomerDto> {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapperImpl;


    @Override
    public ReadCustomerDto create(CreateUpdateCustomerDto createUpdateDto) {

        var customerToSave = customerMapperImpl.toCustomer(createUpdateDto);

        return customerMapperImpl.toReadCustomerDto(
                customerRepository.save(customerToSave)
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
    @Transactional(readOnly = true)
    public ReadCustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapperImpl::toReadCustomerDto)
                .orElseThrow(() -> new CustomerNotFoundException("there is no entity with such id : " + id));
    }


}
