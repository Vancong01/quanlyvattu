package com.codegym.cms.repository;

import com.codegym.cms.model.Material;
import com.codegym.cms.model.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier,Long> {

}
