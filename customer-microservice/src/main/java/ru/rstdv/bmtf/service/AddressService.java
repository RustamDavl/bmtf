package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.entity.Customer;
import ru.rstdv.bmtf.exception.AddressNotFoundException;
import ru.rstdv.bmtf.exception.CustomerNotFoundException;
import ru.rstdv.bmtf.mapper.AddressMapper;
import ru.rstdv.bmtf.repository.AddressRepository;
import ru.rstdv.bmtf.repository.CustomerRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService {

    private final AddressMapper addressMapperImpl;

    private final AddressRepository addressRepository;

    private final CustomerRepository customerRepository;

    public ReadAddressDto create(Long customerId, CreateUpdateAddressDto createUpdateDto) {

        var customer = getCustomerById(customerId);
        customer.getAddresses().add(addressMapperImpl.toAddress(createUpdateDto));

        var savedCustomer = customerRepository.saveAndFlush(customer);
        var listSize = getListSize(savedCustomer);

        return addressMapperImpl.toReadAddressDto(savedCustomer.getAddresses().get(listSize - 1));


    }


    public boolean delete(Long id) {
        var address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return true;
        } else return false;
    }


    public ReadAddressDto update(Long customerId, Long id, CreateUpdateAddressDto createUpdateDto) {

        var customer = getCustomerById(customerId);
        var actualAddress = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("there is no address with id : " + id));

        var updatedAddress = addressMapperImpl.updateAddressFromDto(actualAddress, createUpdateDto);

        var listSize = getListSize(customer);
        if (listSize == 0) {
            customer.getAddresses().set(0, updatedAddress);
        } else {
            customer.getAddresses().set(listSize - 1, updatedAddress);
        }

        var actualCustomer = customerRepository.saveAndFlush(customer);

        return addressMapperImpl.toReadAddressDto(
                actualCustomer.getAddresses().get(getListSize(actualCustomer) - 1)
        );
    }

    @Transactional(readOnly = true)
    public ReadAddressDto findById(Long id) {
        var maybeAddress = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("there is no address with id : " + id));

        return addressMapperImpl.toReadAddressDto(maybeAddress);
    }

    private Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("there is no entity with such customerId : " + id));
    }

    private int getListSize(Customer customer) {
        return customer.getAddresses().size();
    }

}
