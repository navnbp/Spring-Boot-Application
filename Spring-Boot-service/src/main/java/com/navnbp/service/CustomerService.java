package com.navnbp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navnbp.entity.Customer;

@Service
public interface CustomerService {

	List<Customer> getAllCustomers();

	Customer addCustomer(Customer customer);

}
