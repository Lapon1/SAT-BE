package com.lapon.app.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lapon.app.model.RegisterModel;
import com.lapon.constant.BaseNameConection;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public Long insert(RegisterModel form) throws Exception {

		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		sql.append(" INSERT INTO ").append(BaseNameConection.RegisterTable);
		sql.append(" (USERNAME ,PASSWORD ,FNAME ,LNAME ,GENDER) ");		
		sql.append(" VALUES (:username,:password,:fname,:lname,:gender) ");
		param.put("fname", form.getFname());
		param.put("lname", form.getLname());
		param.put("username", form.getUsername());
		param.put("password", form.getPassword());
		param.put("gender", form.getGender());
		int row;
		row = jdbcTemplate.update(sql.toString(), param);

		return row > 0 ? 1L : 0L;
	}

}
