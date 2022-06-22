package com.lapon.app.controller.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Long RegisterOnCreate(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RegisterModel form) throws Exception {
		Long resp = registerService.insert(form);

		return resp;
	}

	@GetMapping(value = "/{fname}")
	public List<RegisterModel> RegisterOnSearch(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fname") String fname) throws Exception {
		List<RegisterModel> data = null;
		data = registerService.search(fname);

		return data;
	}

}
