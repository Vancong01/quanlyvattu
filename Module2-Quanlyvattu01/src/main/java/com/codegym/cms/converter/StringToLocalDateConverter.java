package com.codegym.cms.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    private String datePattern;

    public StringToLocalDateConverter(String datePattern){
        this.datePattern = datePattern;
    }
    @Override
    public LocalDate convert(String source) {
        try{
            return LocalDate.parse(source, DateTimeFormatter.ofPattern(datePattern));
        }catch (DateTimeParseException e){
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""
                    + datePattern + "\"");
        }
    }
}
