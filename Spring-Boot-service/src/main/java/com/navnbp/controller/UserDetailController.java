package com.navnbp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navnbp.entity.UserDetail;
import com.navnbp.notification.EmailService;
import com.navnbp.service.UserDetailService;

@RestController
@RequestMapping("/login")
public class UserDetailController {

	@Autowired
	private UserDetailService loginService;
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/test")
	public String test() {
		return "Testing..";
	}
	
	@GetMapping("/fill")
	public String login() {
		loginService.addLogin(new UserDetail("admin", "admin",true));
		loginService.addLogin(new UserDetail("user", "user"));

		return "Data Added";
	}

	@GetMapping(value = "/all")
	public List<UserDetail> getAll() {
		return loginService.findAll();

	}

	
	@GetMapping(value = "/delete")
	public String delete() {
		 loginService.delete();
		 
		 return "All records deleted";

	}
	
	@GetMapping(value = "/{name}")
	public UserDetail findByUserName(@PathVariable final String name) {
		// return loginService.validateUser(name);
		return null;
	}

//	@PostMapping(value = "/load")
//	public String load(@RequestBody final Login login) {
//		System.out.println(login.getUserName());
//		System.out.println(login.getPassword());
//		return login.getUserName();
//	}
	
	@PostMapping(value = "/validate")
	public String validate(@RequestBody final UserDetail login) {
		return loginService.validateUser(login.getUserName(), login.getPassword());
		
	}
	/*
	{
		"userName" : "a",
		"password" : "a"
		
	}
	*/
	
	@PostMapping(value = "/add")
	public String add(@RequestBody final UserDetail login) {
		loginService.addLogin(login);
		return login.getUserName();
	}
	
	
	@PostMapping(value = "/sendmail")
	public String sendMail(@RequestBody final SimpleMailMessage mail) {
		try {
//			System.out.println(mail.getTo()[0]);
//			System.out.println(mail.getSubject());
//			System.out.println(mail.getText());
			emailService.sendMail(mail.getTo()[0], mail.getSubject(), mail.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mail Sent";
	}
	
	
	/*
{
	"to":"navnbp@gmail.com",
	"subject" : "Sample mail",
	"text" : "Testing"
}


*/
	
	
	@PostMapping(value = "/sendmailWithAttachment")
	public String sendMailWithAttachment(@RequestBody final SimpleMailMessage mail) {
		try {
//			System.out.println(mail.getTo()[0]);
//			System.out.println(mail.getSubject());
//			System.out.println(mail.getText());
			emailService.sendMessageWithAttachment(mail.getTo()[0], mail.getSubject(), mail.getText(),"Sample.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mail Sent";
	}

}
