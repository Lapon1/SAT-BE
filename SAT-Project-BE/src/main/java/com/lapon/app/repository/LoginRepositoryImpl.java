package com.lapon.app.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lapon.app.model.RegisterModel;
import com.lapon.constant.BaseNameConection;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public RegisterModel verify(RegisterModel input) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		sql.append(" SELECT * FROM ").append(BaseNameConection.RegisterTable);
		sql.append(" WHERE username = :username and password = :password ");
		param.put("username", input.getUsername());
		param.put("password", input.getPassword());

		RegisterModel model = jdbcTemplate.queryForObject(sql.toString(), param, new BeanPropertyRowMapper<RegisterModel>(RegisterModel.class));

 		return model;
	}

}
