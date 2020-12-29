package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.request.LoginUserDetails;
import com.auth.service.UserService;

@RestController
@RequestMapping("/security")
public class AppSecurityHomeController {

	@Autowired
	private UserService userService;

	@PostMapping("/register-new-user")
	public void registerNewUser(@RequestBody LoginUserDetails loginUserDetails) {
		userService.saveNewLoginUser(loginUserDetails);
	}

}