package com.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.request.LoginUserDetails;
import com.auth.service.UserService;

@RestController
@RequestMapping("/security")
public class AppSecurityHomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private ConsumerTokenServices consumerTokenServices;

	@PostMapping("/register-new-user")
	public void registerNewUser(@RequestBody LoginUserDetails loginUserDetails) {
		userService.saveNewLoginUser(loginUserDetails);
	}
	
	@PostMapping(value="/invalidateToken")
    public Map<String, String> logout(@RequestParam String accessToken) {
//        LOGGER.debug("Invalidating token {}", accessToken);
        consumerTokenServices.revokeToken(accessToken);
        Map<String, String> ret = new HashMap<>();
        ret.put("access_token", accessToken);
        return ret;
    }

}