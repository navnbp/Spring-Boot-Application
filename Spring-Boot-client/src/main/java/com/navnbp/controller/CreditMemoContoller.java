package com.navnbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreditMemoContoller {

	
	
	
	@RequestMapping(value = "/credit/newMemo", method = RequestMethod.GET)
	public String newCreditMemo() {
	return	"credit/new";
	}
	
	@RequestMapping(value = "/credit/voc", method = RequestMethod.GET)
	public String VOCCreditMemo() {
	return	"credit/voc";
	}
	
}
