package com.navnbp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navnbp.entity.Supplier;

@Service
public interface SupplierService {

	Supplier[] getAllSuppliers();

	Supplier AddSupplier(Supplier supplier);

}
