package com.lapon.app.repository;

import java.util.List;

import com.lapon.app.model.RegisterModel;

public interface RegisterRepository {
	public Long insert(RegisterModel form) throws Exception;

	public List<RegisterModel> search(String fname) throws Exception;

	public Long insertWithProcedure(RegisterModel form) throws Exception;
}
