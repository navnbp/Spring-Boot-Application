package com.navnbp.service.Implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navnbp.config.RestServiceCall;
import com.navnbp.entity.Supplier;
import com.navnbp.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private RestServiceCall restServiceCall;

	@Override
	public Supplier[] getAllSuppliers() {
		ResponseEntity<Supplier[]> response = restServiceCall.execute("/supplier/get", HttpMethod.GET, null,
				Supplier[].class);
		return response.getBody();// supplierRepository.findAll();
	}

	@Override
	public Supplier AddSupplier(Supplier supplier) {
		ResponseEntity<Supplier> response = restServiceCall.execute("/supplier/add", HttpMethod.POST, supplier,
				Supplier.class);

		return response.getBody();
	}
}
