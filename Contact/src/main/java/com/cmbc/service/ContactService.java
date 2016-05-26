package com.cmbc.service;

import java.util.List;

import com.cmbc.po.Contact;

public interface ContactService {

	Contact getContact(int id);
	
	int update(Contact contact);
	
	int delete(int id);
	
	int reg(Contact contact);
	
	Contact login(String name,String password);
	
	int changePwd(int id,String oldPwd,String newPwd);
	
	List<Contact> getContacts();
}
