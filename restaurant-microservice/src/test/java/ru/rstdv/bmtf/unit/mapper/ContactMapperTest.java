package ru.rstdv.bmtf.unit.mapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateContactDto;
import ru.rstdv.bmtf.dto.read.ReadContactDto;
import ru.rstdv.bmtf.entity.Contact;
import ru.rstdv.bmtf.mapper.ContactMapper;
import ru.rstdv.bmtf.mapper.ContactMapperImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ContactMapperImpl.class)
public class ContactMapperTest {

    @Autowired
    private ContactMapper contactMapper;


    @Test
    void toContact() {

        var createUpdateContactDto = new CreateUpdateContactDto(
                "89179209061",
                "89179209061",
                null
        );

        var actualResult = contactMapper.toContact(createUpdateContactDto);

        assertThat(actualResult.getBossPhone()).isEqualTo(createUpdateContactDto.bossPhone());
        assertThat(actualResult.getCommonPhone()).isEqualTo(createUpdateContactDto.commonPhone());
        assertThat(actualResult.getAdditionalPhone()).isNull();
    }

    @Test
    void toReadContactDto() {

        var contact = Contact.builder()
                .id(1L)
                .bossPhone("89179209061")
                .additionalPhone("89179209061")
                .commonPhone("89179209061")
                .build();
        var expectedResult = new ReadContactDto(
                "1",
                "89179209061",
                "89179209061",
                "89179209061"
        );
        var actualResult = contactMapper.toReadContactDto(contact);

        assertThat(actualResult).isEqualTo(expectedResult);


    }
}
