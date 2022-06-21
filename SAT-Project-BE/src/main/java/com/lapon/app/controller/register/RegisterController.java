package com.lapon.app.controller.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lapon.app.model.RegisterModel;
import com.lapon.app.service.register.RegisterService;
import com.lapon.app.service.register.RegisterServiceImpl;

@RestController
@RequestMapping("/register")
public class RegisterController {

@Autowired
public RegisterService registerService;
	
	@PostMapping(value = "/insert")
	public RegisterModel RegisterOnCreate(HttpServletRequest request, HttpServletResponse response,@RequestBody RegisterModel form) throws Exception {
		RegisterModel model = new RegisterModel();
		registerService.insert(form);
		System.out.println("Logger++");
		return model;
	}

}
