package com.codegym.cms.formatter;

import com.codegym.cms.model.Supplier;
import com.codegym.cms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class SupplierFormatter implements Formatter<Supplier> {

    //Chuyển đổi từ id sang object
    private SupplierService supplierService;

    @Autowired
    public SupplierFormatter(SupplierService supplierService){
        this.supplierService = supplierService;
    }
    @Override
    public Supplier parse(String text, Locale locale) throws ParseException {
        return supplierService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Supplier object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
