package ru.rstdv.bmtf.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateContactDto;
import ru.rstdv.bmtf.dto.read.ReadContactDto;
import ru.rstdv.bmtf.entity.Contact;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T21:17:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(CreateUpdateContactDto createUpdateContactDto) {
        if ( createUpdateContactDto == null ) {
            return null;
        }

        Contact.ContactBuilder contact = Contact.builder();

        contact.bossPhone( createUpdateContactDto.bossPhone() );
        contact.commonPhone( createUpdateContactDto.commonPhone() );
        contact.additionalPhone( createUpdateContactDto.additionalPhone() );

        return contact.build();
    }

    @Override
    public ReadContactDto toReadContactDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        String id = null;
        String bossPhone = null;
        String commonPhone = null;
        String additionalPhone = null;

        if ( contact.getId() != null ) {
            id = String.valueOf( contact.getId() );
        }
        bossPhone = contact.getBossPhone();
        commonPhone = contact.getCommonPhone();
        additionalPhone = contact.getAdditionalPhone();

        ReadContactDto readContactDto = new ReadContactDto( id, bossPhone, commonPhone, additionalPhone );

        return readContactDto;
    }
}
