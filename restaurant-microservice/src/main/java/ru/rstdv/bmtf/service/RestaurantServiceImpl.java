package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.exception.OwnerNotFoundException;
import ru.rstdv.bmtf.mapper.MenuCategoryMapper;
import ru.rstdv.bmtf.mapper.RestaurantMapper;
import ru.rstdv.bmtf.repository.OwnerRepository;
import ru.rstdv.bmtf.repository.RestaurantRepository;
@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService<ReadRestaurantDto, CreateUpdateRestaurantDto> {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    private final OwnerRepository ownerRepository;

    private final MenuCategoryMapper menuCategoryMapper;

    @Override
    public ReadRestaurantDto create(CreateUpdateRestaurantDto object) {

        var maybeOwner = ownerRepository.findById(
                        Long.valueOf(object.ownerId())
                )
                .orElseThrow(() -> new OwnerNotFoundException("there is no owner with id " + object.ownerId()));

        var restaurantToSave = restaurantMapper.toRestaurant(object);

        var addressToSave = restaurantToSave.getAddress();

        var contactToSave = restaurantToSave.getContact();

        restaurantToSave.addAddress(addressToSave);

        restaurantToSave.addContact(contactToSave);

        restaurantToSave.setOwner(maybeOwner);

        return restaurantMapper.toReadRestaurantDto(restaurantRepository.save(restaurantToSave));

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public ReadRestaurantDto findById(Long id) {
        return null;
    }

    @Override
    public ReadRestaurantDto update(Long id, CreateUpdateRestaurantDto object) {
        return null;
    }
}
