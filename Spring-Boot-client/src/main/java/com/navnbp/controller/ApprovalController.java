package com.navnbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApprovalController {

	@RequestMapping(value = "/approvals/writeoff", method = RequestMethod.GET)
	public String approveWriteOff() {
		return "";
	}
	
	
	@RequestMapping(value = "/approvals/cvnr", method = RequestMethod.GET)
	public String approveCVNR() {
		return "";
	}
	
	@RequestMapping(value = "/approvals/provider", method = RequestMethod.GET)
	public String providerApproval() {
		return "";
	}
	
	

}
