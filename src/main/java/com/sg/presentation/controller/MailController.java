package com.sg.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sg.presentation.model.Mail;
import com.sg.presentation.service.MailService;

@RestController
public class MailController {
 
	@Autowired
	private MailService notificationService;
	
	/* JSON email...
	{
	    "mailTo": "sgortiz@poligran.edu.co",
	    "mailSubject": "Taller 2",
	    "mailContent": "Se envía el archivo adjunto.",
	    "attachments" : ["C:\Users\Gonzalo\Downloads\libro.pdf"]
	}
	*/
	@RequestMapping(value = "/api/v1/msg", method=RequestMethod.GET)
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email enviado";
	}
	

}