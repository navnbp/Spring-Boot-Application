package com.navnbp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.navnbp.entity.Customer;
import com.navnbp.service.CustomerService;

@Controller

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	List<Customer> customerList = new ArrayList<>();

	@RequestMapping(value = "/customer/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> getCustomers() {
		customerList = Collections.unmodifiableList(Arrays.asList(customerService.getAllCustomers()));
		return customerList;
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/addCustomer";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(final Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/get";

	}

	
	@RequestMapping(value = "/customer/getByNames", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> simulateSearchResult(String name, HttpServletResponse response) {

		if (customerList == null || customerList.size() == 0)
			this.getCustomers();
		List<Customer> result = null;
		Comparator<Customer> compare=(c1,c2)->c1.getName().toLowerCase().compareTo(c2.getName().toLowerCase());
		
		if (name == null || name.length() == 0) {
			result = this.customerList.stream()
					.sorted(compare)
					.collect(Collectors.toList());
		} else {
			result = this.customerList.stream()
					.filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
					.sorted(compare).collect(Collectors.toList());
		}

			return result;
	}

}
