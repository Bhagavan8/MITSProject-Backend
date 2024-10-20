package com.web.mits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.mits.databaseutil.DatabaseUtil;
import com.web.mits.model.Register;
import com.web.mits.repository.RegisterRepository;
import com.web.mits.util.HashUtil;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private DatabaseUtil databaseUtil;

	
	public Register saveUser(Register user) {
		return registerRepository.save(user);
	}

	public boolean authenticateMobile(String mobile) {
		return databaseUtil.validateMobile(mobile);
	}

	public boolean authenticateEmail(String email) {
		return databaseUtil.validateEmail(email);
	}
	
	public boolean validatePassword(String password) {
		String passwordhashcode = HashUtil.hashString(password);
		return databaseUtil.validatePassword(passwordhashcode);
	}

}
