package com.codegym.cms.service;

import com.codegym.cms.model.Supplier;

import com.codegym.cms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SupplierServiceImpl implements SupplierService{


    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Iterable<Supplier> findAll() {

        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findOne(id);
    }

    @Override
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    @Override
    public void remove(Long id) {
        supplierRepository.delete(id);
    }

}
