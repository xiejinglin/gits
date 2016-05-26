package com.cmbc.dao;

import java.util.List;

import com.cmbc.po.Contact;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
    
    Contact getByNamePwd(String name,String password);
    
    int changePwd(int id,String oldPwd,String newPwd);
    
    List<Contact> getContacts();
}