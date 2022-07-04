package com.lapon.app.service.menuview;

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
public class MenuViewRepositoryImpl implements MenuViewRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

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
