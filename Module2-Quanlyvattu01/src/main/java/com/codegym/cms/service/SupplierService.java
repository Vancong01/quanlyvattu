package com.codegym.cms.service;

import com.codegym.cms.model.Supplier;

import java.util.List;

public interface SupplierService {
    Iterable<Supplier> findAll();
    Supplier findById(Long id);
    void save(Supplier supplier);
    void remove(Long id);
}
