package com.lapon.app.service.register;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lapon.app.model.RegisterModel;
import com.lapon.app.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	private final Logger logger = LogManager.getLogger(RegisterServiceImpl.class);

	@Autowired
	public RegisterRepository registerRepository;

	@Override
	@Transactional(readOnly = false)
	public Long insert(RegisterModel form) throws Exception {
		try {
			return registerRepository.insert(form);
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<RegisterModel> search(String fname) throws Exception {
		try {
			return registerRepository.search(fname);
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}
	}

}
