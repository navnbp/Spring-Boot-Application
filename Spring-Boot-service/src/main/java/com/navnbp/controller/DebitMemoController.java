package com.navnbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navnbp.entity.DebitMemo;
import com.navnbp.entity.Supplier;
import com.navnbp.service.DebitMemoService;

@RestController
@RequestMapping("/debit")
public class DebitMemoController {

	
	@Autowired
	private DebitMemoService debitMemoService;
	
	
	@RequestMapping(value="/debit/get", method = RequestMethod.GET)
	public List<DebitMemo> getDebitMemos() {
		return debitMemoService.getAllDebitMemo();
	}
	
	@RequestMapping("/debit")
	public DebitMemo addDebitMemo(@RequestBody final DebitMemo debitMemo) 
	{
		return debitMemoService.addDebitMemo(debitMemo);
		
	}
	
}
