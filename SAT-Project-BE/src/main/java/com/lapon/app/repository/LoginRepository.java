package com.lapon.app.repository;

import com.lapon.app.model.RegisterModel;

public interface LoginRepository {

	RegisterModel verify(RegisterModel input) throws Exception;

	RegisterModel verifyByProcedure(RegisterModel input) throws Exception;

}
