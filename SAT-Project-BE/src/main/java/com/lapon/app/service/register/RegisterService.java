package com.lapon.app.service.register;

import java.util.List;

import com.lapon.app.model.RegisterModel;

public interface RegisterService {

	public Long insert(RegisterModel form)throws Exception;

	public List<RegisterModel> search(String fname)throws Exception;
	
}