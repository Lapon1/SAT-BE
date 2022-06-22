package com.lapon.app.service.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lapon.app.model.RegisterModel;
import com.lapon.app.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	private final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional(readOnly = true)
	public RegisterModel verify(RegisterModel input) throws Exception {

		try {
			return loginRepository.verify(input);

		} catch (EmptyResultDataAccessException e) {
			return new RegisterModel();
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}

	}

}
