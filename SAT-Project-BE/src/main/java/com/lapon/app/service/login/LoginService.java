package com.lapon.app.service.login;

import com.lapon.app.model.RegisterModel;

public interface LoginService {

	public RegisterModel verify(RegisterModel input) throws Exception;

	public RegisterModel getDataByView(RegisterModel input) throws Exception;

}
