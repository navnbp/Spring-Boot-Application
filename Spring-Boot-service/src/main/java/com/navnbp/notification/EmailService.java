package com.navnbp.notification;

public interface EmailService {
	
	 void sendMail(String to,String subject,String text) throws Exception ;

	  void sendMessageWithAttachment(
			  String to, String subject, String text, String pathToAttachment) throws Exception ;
			   
}
