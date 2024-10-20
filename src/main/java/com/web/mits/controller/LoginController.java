package com.web.mits.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.mits.service.RegisterService;

@RestController
@RequestMapping("/college/mits")
public class LoginController {

	@Autowired
	private RegisterService registerService;

	@PostMapping("/verifyLogin")
	public Map<String, String> verifyLoginDetails(@RequestParam String email, @RequestParam String password) {
		Map<String, String> loginDetails = new HashMap<String, String>();
		if (!registerService.authenticateEmail(email)) {
			loginDetails.put("status", "100");
			loginDetails.put("message", "Email authentication failed");
			return loginDetails;
		} else if (!registerService.validatePassword(password)) {
			loginDetails.put("status", "100");
			loginDetails.put("message", "Password is incorrect");
			return loginDetails;

		} else {
			loginDetails.put("status", "200");
			loginDetails.put("message", "Login successfull");
		}
		return loginDetails;
	}

}
