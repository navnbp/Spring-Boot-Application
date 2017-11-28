package com.navnbp.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navnbp.entity.Customer;
import com.navnbp.repository.CustomerRepository;
import com.navnbp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
}
