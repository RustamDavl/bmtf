package ru.rstdv.bmtf.service;

public interface RestaurantService <R, C>{

    R create(C object);

    boolean delete(Long id);

    R findById(Long id);

    R update(Long id, C object);


}
