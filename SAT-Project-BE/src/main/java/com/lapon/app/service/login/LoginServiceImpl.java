package com.lapon.app.service.login;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
			ObjectMapper mapper = new ObjectMapper();
			final String uri = "http://localhost:8082/login/verify";
			final String urival = "http://localhost:8082/login/get/{id}";
			final String urivalue = "http://localhost:8082/login/getList/{id}";
			Integer val = 1;

			RestTemplate restTemplate = new RestTemplate();
			RegisterModel model = new RegisterModel();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			RegisterModel result = restTemplate.postForObject(uri, input, RegisterModel.class);
			ResponseEntity<String> result = restTemplate.postForEntity(uri, input, String.class);
			if (result.getStatusCode() == HttpStatus.OK) {
				RegisterModel rmodel = mapper.readValue(result.getBody(), RegisterModel.class);
				System.out.println(rmodel);
			} else {
				throw new Exception();
			}
//			RegisterModel resultVal = restTemplate.getForObject(urival,RegisterModel.class,val);
			ResponseEntity<String> response = restTemplate.getForEntity(urival, String.class, val);
			if (response.getStatusCode() == HttpStatus.OK) {
				RegisterModel rmodel = mapper.readValue(response.getBody(), RegisterModel.class);
				System.out.println(rmodel);
			} else {
				throw new Exception();
			}
//			RegisterModel resultVal = restTemplate.getForObject(urival,RegisterModel.class,val);
			HttpEntity<RegisterModel> entity = new HttpEntity<RegisterModel>(model, headers);
			ResponseEntity<List<RegisterModel>> responseValue = restTemplate.exchange(urivalue, HttpMethod.GET,entity, new ParameterizedTypeReference<List<RegisterModel>>() {}, val);
			if (responseValue.getStatusCode() == HttpStatus.OK) {
				System.out.println(response.getBody());
			} else {
				throw new Exception();
			}

			return loginRepository.verify(input);

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

	@Override
	@Transactional(readOnly = true)
	public RegisterModel getDataByView(Long id) throws Exception {
		logger.info("start getDataByView");
		try {
			return loginRepository.getDataByView(id);

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
