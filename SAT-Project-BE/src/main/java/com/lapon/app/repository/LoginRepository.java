package com.lapon.app.repository;

import com.lapon.app.model.RegisterModel;

public interface LoginRepository {

	public RegisterModel verify(RegisterModel input) throws Exception;

	public RegisterModel verifyByProcedure(RegisterModel input) throws Exception;

	public RegisterModel getDataByView(RegisterModel input) throws Exception;

	public RegisterModel getDataByView(Long id) throws Exception;

}
