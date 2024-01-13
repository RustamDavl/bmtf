package ru.rstdv.bmtf.service;

import ru.rstdv.bmtf.dto.createupdate.CreateUpdateOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;

public interface OwnerService<R, C> {

    R create(C object);

    boolean delete(Long id);

    R findById(Long id);

    R update(Long id, C object);
}
