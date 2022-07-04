package com.lapon.app.service.menuview;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lapon.app.model.RegisterModel;

@Service
public class MenuViewServiceImpl implements MenuViewService {
	MenuViewRepository menuviewRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<RegisterModel> search(String fname) throws Exception {
		try {
			return menuviewRepository.search(fname);
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
