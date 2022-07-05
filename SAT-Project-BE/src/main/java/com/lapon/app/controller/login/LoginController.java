package com.lapon.app.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lapon.app.core.controller.ResponseController;
import com.lapon.app.core.model.ResponseVo;
import com.lapon.app.model.RegisterModel;
import com.lapon.app.service.login.LoginService;
import com.lapon.app.service.login.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController extends ResponseController {

	private final Logger logger = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginService loginService;

	@PostMapping("/verify")
	public ResponseVo<RegisterModel> verify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RegisterModel input) throws Exception {
		RegisterModel RegisModel = new RegisterModel();
		ResponseVo<RegisterModel> responseModel = new ResponseVo<RegisterModel>();
		RegisModel = loginService.verify(input);
		if (RegisModel != null) {
			responseModel.setHeader(initHeaderSuccess(RegisModel));
			responseModel.setData(RegisModel);
		}
		return responseModel;
	}

	@PostMapping("/TestController1")
	public RegisterModel test(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RegisterModel input) throws Exception {
		RegisterModel RegisModel = new RegisterModel();
		RegisModel = loginService.getDataByView(input);

		return RegisModel;
	}

}
