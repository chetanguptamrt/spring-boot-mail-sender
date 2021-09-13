package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mail.Service.EmailService;
import com.mail.model.MailDetail;

@Controller
public class MainController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/sendMail", method = RequestMethod.POST)
	@ResponseBody
	public String sendMail(@ModelAttribute MailDetail mailDetail) {
		String done = this.emailService.sendMail(mailDetail);
		return done;
	}

}
