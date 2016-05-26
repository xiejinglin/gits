package com.cmbc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cmbc.po.Contact;
import com.cmbc.service.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestContactService {

	@Autowired
	private ContactService contactService;
	
	@Test
	public void testChangePwd(){
		int id = 2;
		String oldPwd = "admin";
		String newPwd = "5452830";
		int i = contactService.changePwd(id, oldPwd, newPwd);
		System.out.println(i);
	}
	
	@Test
	public void testGetContacts(){
		
		List<Contact> contacts = contactService.getContacts();
		
		System.out.println(JSON.toJSONStringWithDateFormat(contacts, "yyyy-MM-dd"));
		
	}
}
