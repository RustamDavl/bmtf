package ru.rstdv.bmtf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;
import ru.rstdv.bmtf.exception.EmailDuplicationException;
import ru.rstdv.bmtf.mapper.OwnerMapper;
import ru.rstdv.bmtf.repository.OwnerRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerServiceImpl implements OwnerService<ReadOwnerDto, CreateUpdateOwnerDto> {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapperImpl;


    @Override
    public ReadOwnerDto create(CreateUpdateOwnerDto object) {
        var isOwnerPresent = ownerRepository.findByEmail(object.email()).isPresent();

        if (isOwnerPresent) {
            throw new EmailDuplicationException(object.email() + " email already exists");
        }
        return ownerMapperImpl.toReadOwnerDto(
                ownerRepository.save(
                        ownerMapperImpl.toOwner(object)
                )
        );
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ReadOwnerDto findById(Long id) {
        return null;
    }

    @Override
    public ReadOwnerDto update(Long id, CreateUpdateOwnerDto object) {
        return null;
    }
}
