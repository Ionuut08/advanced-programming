package com.ionut.hplusapp.convertors;

import com.ionut.hplusapp.model.*;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String s) {
        // return Gender.valueOf(s.toUpperCase());
        if (s.equals("Male")) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }
}
