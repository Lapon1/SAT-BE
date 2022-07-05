package com.lapon.app.service.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lapon.app.core.exception.Exception1001;
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
		logger.info("start verify account");
		try {
			return loginRepository.verifyByProcedure(input);

		} catch (EmptyResultDataAccessException e) {
			return new RegisterModel();
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new Exception1001(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	@Transactional(readOnly = true)
	public RegisterModel getDataByView(RegisterModel input) throws Exception {
		logger.info("start getDataByView");
		try {
			return loginRepository.getDataByView(input);

		} catch (EmptyResultDataAccessException e) {
			return new RegisterModel();
		} catch (DataAccessException e) {
			logger.error(" error dataAcess", e);
			throw new Exception1001(e.getMessage());
		} catch (Exception e) {
			logger.error(" error ", e);
			logger.error(" error ", e);
			throw new RuntimeException(e.getMessage());
		}
	}
}
