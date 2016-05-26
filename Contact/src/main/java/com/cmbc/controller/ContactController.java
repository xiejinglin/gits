package com.cmbc.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cmbc.po.Contact;
import com.cmbc.service.ContactService;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

	private static final Log logger = LogFactory.getLog(ContactController.class);

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/reg_form")
	public String getRegForm(Model model) {
		logger.info("getRegForm method invoked");
		model.addAttribute("contact", new Contact());
		return "regform";
	}

	@RequestMapping(value = "/reg")
	public String reg(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model) {
		logger.info(
				"reg method invoked and receive the param :" + JSON.toJSONStringWithDateFormat(contact, "yyyy-MM-dd"));
		// 判断传入的contact是否满足验证规则
		if (bindingResult.hasErrors()) {
			return "regform";
		}
		int regResult = contactService.reg(contact);
		logger.info("reg status :" + regResult);
		model.addAttribute("contact", contact);
		return "";
	}

	@RequestMapping(value = "/login_form")
	public String getLoginForm(Model model) {
		logger.info("getLoginForm method invoked");
		model.addAttribute("contact", new Contact());
		return "loginform";
	}

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute Contact contact) {
		logger.info("login method invoked and received the param :" + JSON.toJSONString(contact));
		contact = contactService.login(contact.getName(), contact.getPassword());
		logger.info("login status :" + JSON.toJSONStringWithDateFormat(contact, "yyyy-MM-dd"));
		return "personalMsg";
	}

}
