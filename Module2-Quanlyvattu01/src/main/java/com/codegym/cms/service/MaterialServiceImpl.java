package com.codegym.cms.service;

import com.codegym.cms.model.Material;
import com.codegym.cms.model.Supplier;
import com.codegym.cms.repository.MaterialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public class MaterialServiceImpl implements MaterialService{

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Iterable<Material> findAll() {

        return materialRepository.findAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepository.findOne(id);
    }

    @Override
    public void save(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void remove(Long id) {
        materialRepository.delete(id);
    }

    @Override
    public Iterable<Material> findAllBySupplier(Supplier supplier) {
        return materialRepository.findAllBySupplier(supplier);
    }
    //Phân trang của sản phẩm
    @Override
    public Page<Material> findAll(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }

    @Override
    public Page<Material> findAllByNameContaining(String name,Pageable pageable) {
        return materialRepository.findAllByNameContaining(name,pageable);
    }

}
