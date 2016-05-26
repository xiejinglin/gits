package com.cmbc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:/contact/login_form.do";
	}

	@RequestMapping(value = "/login_form")
	public String getLoginForm(Model model) {
		logger.info("getLoginForm method invoked");
		model.addAttribute("contact", new Contact());
		return "loginform";
	}

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute Contact contact, Model model) {
		logger.info("login method invoked and received the param :" + JSON.toJSONString(contact));
		contact = contactService.login(contact.getName(), contact.getPassword());
		logger.info("login status :" + JSON.toJSONStringWithDateFormat(contact, "yyyy-MM-dd"));
		if (contact == null) {
			model.addAttribute("contact", new Contact());
			model.addAttribute("loginMsg", "您输入法的密码有误");
			return "loginform";
		}
		model.addAttribute("contact", contact);
		return "personalMsg";
	}

	@RequestMapping(value = "/update_form/{id}")
	public String getUpdateForm(@PathVariable int id, Model model) {
		logger.info("getUpdateForm method invoked and receive the param : " + id);
		Contact contact = contactService.getContact(id);
		logger.info("get contacgt by the id : " + contact);
		model.addAttribute("contact", contact);
		return "updateform";
	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model) {
		logger.info("update method invoked and receive the param : "
				+ JSON.toJSONStringWithDateFormat(contact, "yyyy-MM-dd"));
		if (bindingResult.hasErrors()) {
			return "updateform";
		}
		int updateResult = contactService.update(contact);
		logger.info("update status : " + updateResult);
		return "personalMsg";
	}

	@RequestMapping(value = "/changePwd_form/{id}")
	public String getChangePwdForm(@PathVariable int id, Model model) {
		logger.info("getChangePwdForm method invoked and received the param : " + id);
		Contact contact = new Contact();
		contact.setId(id);
		model.addAttribute("contact", contact);
		return "changepwd";
	}

	@RequestMapping(value = "/changePwd")
	public String changePwd(@ModelAttribute Contact contact, String newPwd) {
		logger.info("changePwd method invoked and receive the param : id=" + contact.getId() + ",oldPwd = "
				+ contact.getPassword() + ",newPwd =" + newPwd);
		int changePwdResult = contactService.changePwd(contact.getId(), contact.getPassword(), newPwd);
		logger.info("changePwd method status : " + changePwdResult);
		return "redirect:/contact/login_form.do";
	}

	@RequestMapping(value = "/contact_list")
	public String getContacts(Model model) {
		logger.info("getContacts method invoked");
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
		return "contactlist";
	}

	@RequestMapping(value="/contact_delete/{id}")
	public String delete(@PathVariable int id){
		logger.info("delete method invoked and receive the param : "+id);
		contactService.delete(id);
		return "redirect:/contact/contact_list.do";
	}
}
