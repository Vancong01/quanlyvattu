package com.codegym.cms.service;

import com.codegym.cms.model.Material;
import com.codegym.cms.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


import java.util.List;

public interface MaterialService {
    Iterable<Material> findAll();
    Material findById(Long id);
    void save( Material material);
    void remove(Long id);
    //Hiển thị danh sách nhà cung cấp
    Iterable<Material> findAllBySupplier(Supplier supplier);
    //Phân trang
    Page<Material> findAll(Pageable pageable);
    Page<Material>  findAllByNameContaining(String name, Pageable pageable);
}
