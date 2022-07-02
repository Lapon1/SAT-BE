package com.lapon.app.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public Long insertWithProcedure(RegisterModel form) throws Exception {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" CALL ").append(BaseNameConection.RegisterProcedure);
		sbSql.append(" (:id ");
		sbSql.append(" ,:fname  ");
		sbSql.append(" ,:lname  ");
		sbSql.append(" )");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 1);
		param.put("fname", form.getFname());
		param.put("lname", form.getLname());
		int row;
		row = jdbcTemplate.update(sbSql.toString(), param);

		return row > 0 ? 1L : 0L;
	}

	@Override
	public List<RegisterModel> search(String fname) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		sql.append(" SELECT * FROM ").append(BaseNameConection.RegisterTable);
		sql.append(" WHERE fname = :fname ");
		param.put("fname", fname);

		List<RegisterModel> list = jdbcTemplate.query(sql.toString(), param,
				new BeanPropertyRowMapper<RegisterModel>(RegisterModel.class));

		return list;
	}

}
