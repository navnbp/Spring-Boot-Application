package com.navnbp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.navnbp.entity.DebitMemo;
import com.navnbp.service.DebitMemoService;

@Controller
public class DebitMemoController {

	
	@Autowired
	private DebitMemoService debitMemoService;
	
	
	
	
	@RequestMapping(value = "/debit/search", method = RequestMethod.GET)
	public String searchDebitMemos() {
	return	"debitMemo/search";
	}
	
	
	@RequestMapping(value = "/debit/print", method = RequestMethod.GET)
	public String printDebitMemos() {
	return	"debitMemo/print";
	}
	
	@RequestMapping(value = "/debit/manualDebit", method = RequestMethod.GET)
	public String addManualDebitMemo(Model model) 
	{
		model.addAttribute("debitMemo", new DebitMemo());
		 
		 return "";
		
	}
	
	@RequestMapping(value = "/debit/statement", method = RequestMethod.GET)
	public String debitMemoStatement() {
	return	"debitMemo/statement";
	}
	
	
	//---------------------------------------------
	
	@RequestMapping(value = "/debit/get", method = RequestMethod.GET)
	public List<DebitMemo> getDebitMemos() {
	return	Collections.unmodifiableList(Arrays.asList(debitMemoService.getAllDebitMemo()));
		
	}
	
	@RequestMapping(value = "/debit/add", method = RequestMethod.GET)
	public String addDebitMemo(Model model) 
	{
		model.addAttribute("debitMemo", new DebitMemo());
		 
		 return "/debitMemo/addDebitMemo";
		
	}
	@RequestMapping(value = "/debit/add", method = RequestMethod.POST)
	public String addDebitMemo(final DebitMemo debitMemo) 
	{
		 debitMemoService.addDebitMemo(debitMemo);
		 return null;
		
	}
	
	
	
}
