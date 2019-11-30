package com.codegym.cms.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    private DateTimeFormatter formatter;
    private String datePattern;

    public LocalDateFormatter(String datePattern){
        this.datePattern = datePattern;
        formatter =DateTimeFormatter.ofPattern(datePattern);
    }
    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(formatter);
    }
    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        try{
            return LocalDate.parse(s,DateTimeFormatter.ofPattern(datePattern));
        }catch (DateTimeParseException e){
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""
                    + datePattern + "\"");
        }
    }

//    @Component
//    public class DepartmentFormatter implements Formatter<Department> {
//
//        private DepartmentService departmentService;
//
//        @Autowired
//        public DepartmentFormatter(DepartmentService departmentService){
//            this.departmentService = departmentService;
//        }
//        @Override
//        public Department parse(String text, Locale locale) throws ParseException {
//            return departmentService.findById(Long.parseLong(text));
//        }
//
//        @Override
//        public String print(Department object, Locale locale) {
//            return "["+object.getId()+","+object.getName()+"]";
//        }
//    }
}
