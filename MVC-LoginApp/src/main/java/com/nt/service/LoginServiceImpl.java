package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDao;
import com.nt.dto.UserDTO;
@Service("logService")
public class LoginServiceImpl implements LoginService {
@Autowired
	private LoginDao dao;
	@Override
	public String authenticate(UserDTO dto) {
		UserBO bo=null;
	int cnt=0;
		//convert dto to bo
	bo=new UserBO();
	bo.setUsername(dto.getUsername());
	bo.setPwd(dto.getPwd());
	//use dao class
	cnt=dao.validate(bo);
	if(cnt==0)
		return "Invalid Credentials";
	else
		return "Valid Credentials";
	}

}
