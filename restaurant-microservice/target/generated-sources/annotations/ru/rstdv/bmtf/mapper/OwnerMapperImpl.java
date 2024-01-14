package ru.rstdv.bmtf.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;
import ru.rstdv.bmtf.entity.Owner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T21:17:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public ReadOwnerDto toReadOwnerDto(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        String id = null;
        String email = null;
        String phone = null;

        if ( owner.getId() != null ) {
            id = String.valueOf( owner.getId() );
        }
        email = owner.getEmail();
        phone = owner.getPhone();

        String name = null;

        ReadOwnerDto readOwnerDto = new ReadOwnerDto( id, name, email, phone );

        return readOwnerDto;
    }

    @Override
    public Owner toOwner(CreateUpdateOwnerDto createUpdateOwnerDto) {
        if ( createUpdateOwnerDto == null ) {
            return null;
        }

        Owner.OwnerBuilder owner = Owner.builder();

        owner.email( createUpdateOwnerDto.email() );
        owner.phone( createUpdateOwnerDto.phone() );
        owner.password( createUpdateOwnerDto.password() );

        return owner.build();
    }
}
