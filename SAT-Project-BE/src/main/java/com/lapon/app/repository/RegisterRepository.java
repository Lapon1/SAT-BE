package com.lapon.app.repository;

import com.lapon.app.model.RegisterModel;

public interface RegisterRepository {
	public Long insert(RegisterModel form)throws Exception;
}
