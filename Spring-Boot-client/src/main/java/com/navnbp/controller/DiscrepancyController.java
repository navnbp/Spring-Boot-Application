package com.navnbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DiscrepancyController {

	@RequestMapping(value = "/discrepancy/debit", method = RequestMethod.GET)
	public String getDiscrepancyDebitMemo() {
	return	"discrepancy/debit";
	}
	
	
	@RequestMapping(value = "/discrepancy/credit", method = RequestMethod.GET)
	public String getDiscrepancyCreditMemo() {
	return	"discrepancy/credit";
	}
	
	@RequestMapping(value = "/discrepancy/spf", method = RequestMethod.GET)
	public String getDiscrepancySPF() {
	return	"discrepancy/spf";
	}
	
}
