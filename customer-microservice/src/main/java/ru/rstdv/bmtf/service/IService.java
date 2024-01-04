package ru.rstdv.bmtf.service;

public interface IService<R, C> {

    R create(C createUpdateDto);

    boolean delete(Long id);

    R update(Long id, C createUpdateDto);

    R findById(Long id);
}
