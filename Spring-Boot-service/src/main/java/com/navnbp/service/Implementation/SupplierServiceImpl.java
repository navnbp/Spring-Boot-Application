package com.navnbp.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navnbp.entity.Supplier;
import com.navnbp.repository.SupplierRepository;
import com.navnbp.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAllSuppliers() {
		
		return supplierRepository.findAll();
	}

	@Override
	public Supplier AddSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
}
