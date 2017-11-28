package com.navnbp.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navnbp.entity.Customer;
import com.navnbp.entity.Supplier;
import com.navnbp.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	private List<Supplier> supplierList = null;

	@RequestMapping(value = "/supplier/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Supplier> getSuppliers() {
		supplierList = Collections.unmodifiableList(Arrays.asList(supplierService.getAllSuppliers()));

		return supplierList;

	}

	@RequestMapping(value = "/supplier/add", method = RequestMethod.GET)
	public String addSuppliers(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier/add";
	}

	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSuppliers(final Supplier supplier) {
		supplierService.AddSupplier(supplier);
		return "redirect:/supplier/get";

	}

	@RequestMapping(value = "/supplier/getByNames", method = RequestMethod.GET)
	@ResponseBody
	public List<Supplier> simulateSearchResult(String name) {

		if (supplierList == null || supplierList.size() == 0)
			this.getSuppliers();
		List<Supplier> result = null;
		Comparator<Supplier> compare = (c1, c2) -> c1.getName().toLowerCase().compareTo(c2.getName().toLowerCase());

		if (name == null || name.length() == 0) {
			result = this.supplierList.stream()
					.sorted(compare)
					.collect(Collectors.toList());
		} else {
			result = this.supplierList.stream()
					.filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
					.sorted(compare).collect(Collectors.toList());
		}

		return result;

	}

	@RequestMapping(value = "/supplier/leadSupplier", method = RequestMethod.GET)
	@ResponseBody
	public List<Supplier> leadSupplierSearchResult(String name) {

		if (supplierList == null || supplierList.size() == 0)
			this.getSuppliers();
		List<Supplier> result = null;
		Comparator<Supplier> compare = (c1, c2) -> c1.getName().toLowerCase().compareTo(c2.getName().toLowerCase());

		if (name == null || name.length() == 0) {
			result = this.supplierList.stream().filter(s -> true == s.getIsLeadSupplier()).sorted(compare)
					.collect(Collectors.toList());
		} else {
			result = this.supplierList.stream().filter(s -> true == s.getIsLeadSupplier())

					.filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).sorted(compare)
					.collect(Collectors.toList());
		}

		return result;

	}

}
