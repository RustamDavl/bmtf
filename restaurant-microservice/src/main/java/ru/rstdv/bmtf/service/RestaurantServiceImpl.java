package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.mapper.RestaurantMapper;
import ru.rstdv.bmtf.repository.RestaurantRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService<ReadRestaurantDto, CreateUpdateRestaurantDto> {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    @Override
    public ReadRestaurantDto create(CreateUpdateRestaurantDto object) {

        return restaurantMapper.toReadRestaurantDto(restaurantMapper.toRestaurant(object));
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
