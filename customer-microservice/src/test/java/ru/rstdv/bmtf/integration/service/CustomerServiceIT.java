package ru.rstdv.bmtf.integration.service;

import lombok.RequiredArgsConstructor;
import ru.rstdv.bmtf.integration.IntegrationTestBase;
import ru.rstdv.bmtf.integration.annotation.IT;
import ru.rstdv.bmtf.service.CustomerService;


@RequiredArgsConstructor
public class CustomerServiceIT extends IntegrationTestBase {

    private final CustomerService customerService;


}
