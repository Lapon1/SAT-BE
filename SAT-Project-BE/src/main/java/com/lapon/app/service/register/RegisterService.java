package com.lapon.app.service.register;

import com.lapon.app.model.RegisterModel;

public interface RegisterService {

	public Long insert(RegisterModel form)throws Exception;
	
}