package com.cmbc.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmbc.dao.ContactMapper;
import com.cmbc.po.Contact;
import com.cmbc.util.MD5;
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
		try {
			contact.setPassword(MD5.getMd5(contact.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactMapper.insertSelective(contact);
	}

	@Override
	public Contact login(String name, String password) {
		// TODO Auto-generated method stub
		try {
			password = MD5.getMd5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactMapper.getByNamePwd(name, password);
	}

	@Override
	public int changePwd(int id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		try {
			oldPwd = MD5.getMd5(oldPwd);
			newPwd = MD5.getMd5(newPwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return contactMapper.changePwd(id, oldPwd, newPwd);
	}

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return contactMapper.getContacts();
	}

}
