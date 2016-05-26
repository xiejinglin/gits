package com.cmbc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
