package com.lapon.app.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lapon.app.core.controller.ResponseController;
import com.lapon.app.model.RegisterModel;
import com.lapon.app.service.login.LoginService;

@RestController
@RequestMapping("/login")
public class TestLogin extends ResponseController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/TestController1")
	public RegisterModel test(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RegisterModel input) throws Exception {
		RegisterModel RegisModel = new RegisterModel();
		RegisModel = loginService.verify(input);
		String val ="M";
		RegisModel.setGender(val);
		return RegisModel;
	}
}
