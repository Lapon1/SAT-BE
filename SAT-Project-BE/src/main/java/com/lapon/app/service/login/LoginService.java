package com.lapon.app.service.login;

import com.lapon.app.model.RegisterModel;

public interface LoginService {

	RegisterModel verify(RegisterModel input) throws Exception;

}
