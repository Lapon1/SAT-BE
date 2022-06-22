package com.lapon.app.service.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lapon.app.model.RegisterModel;
import com.lapon.app.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	public RegisterRepository registerRepository;

	public Long insert(RegisterModel form) throws Exception {
		return registerRepository.insert(form);

	}

	@Override
	public List<RegisterModel> search(String fname) throws Exception {
		return registerRepository.search(fname);
	}

}
