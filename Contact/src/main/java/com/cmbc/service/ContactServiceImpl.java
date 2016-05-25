package com.cmbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmbc.dao.ContactMapper;
import com.cmbc.po.Contact;
@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return contactMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.updateByPrimaryKeySelective(contact);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return contactMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int reg(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.insertSelective(contact);
	}

	@Override
	public Contact login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changePwd(int id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
