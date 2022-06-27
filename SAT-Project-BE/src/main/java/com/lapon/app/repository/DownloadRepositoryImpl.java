package com.lapon.app.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lapon.app.model.DownloadModel;
import com.lapon.constant.BaseNameConection;

@Repository
public class DownloadRepositoryImpl implements DownloadRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public DownloadModel find(Long id) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		sql.append(" SELECT PATHNAME FROM ").append(BaseNameConection.DownloadTable);
		sql.append(" WHERE ID = :id ");
		param.put("id", id);

		DownloadModel model = jdbcTemplate.queryForObject(sql.toString(), param, new BeanPropertyRowMapper<DownloadModel>(DownloadModel.class));

 		return model;
	}

}
