package com.lapon.app.service.menuview;

import java.util.List;

import com.lapon.app.model.RegisterModel;

public interface MenuViewRepository {
	public List<RegisterModel> search(String fname) throws Exception;

}
