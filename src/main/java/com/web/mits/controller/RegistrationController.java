package com.web.mits.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.mits.model.Register;
import com.web.mits.service.EmailService;
import com.web.mits.service.RegisterService;
import com.web.mits.util.HashUtil;


@RestController
@RequestMapping("/college/mits")
public class RegistrationController{

	@Autowired
	private RegisterService registerService;

	@PostMapping("/register")
	public Map<String, String> register(@RequestParam("mobilenumber") String mobilenumber,
			@RequestParam("email") String email, @RequestParam("name") String name, String password) {
		Map<String, String> response = new HashMap<>();
		try {
			if (registerService.authenticateEmail(email)) {
				response.put("status", "100");
				response.put("message", "Email already exists");
				return response;
			} else if (registerService.authenticateMobile(mobilenumber)) {
				response.put("status", "100");
				response.put("message", "Mobile Number already exists");
				return response;
			} else {
				Register user = new Register();
				String passwordhashcode = HashUtil.hashString(password);
				user.setEmail(email);
				user.setMobileNumber(mobilenumber);
				user.setName(name);
				user.setPassword(passwordhashcode);
				registerService.saveUser(user);
				response.put("status", "200");
				response.put("message", "Registration is completed");
				EmailService.sendEmail();
			}
		} catch (Exception ex) {
			response.put("status", "400");
			response.put("error", ex.getMessage());
			ex.printStackTrace();

		}

		return response;
	}

}
