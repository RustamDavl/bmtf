package ru.rstdv.bmtf.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CountryCodeInjector {


    public static String countryCode;

    @Value("${app.mobile.code.russia}")
    private void setCountryCode(String countryCode) {
        CountryCodeInjector.countryCode = countryCode;
    }


    public static String injectCountryCode() {
        return countryCode;
    }

}
