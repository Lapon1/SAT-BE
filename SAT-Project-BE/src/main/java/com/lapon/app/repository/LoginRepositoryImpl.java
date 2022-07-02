package com.lapon.app.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
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

		RegisterModel model = jdbcTemplate.queryForObject(sql.toString(), param,
				new BeanPropertyRowMapper<RegisterModel>(RegisterModel.class));

		return model;
	}

	@Override
	public RegisterModel verifyByProcedure(RegisterModel input) throws Exception {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Getting the connection
		String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		Connection con = DriverManager.getConnection(mysqlUrl, "SYS AS SYSDBA", "05315099");

		CallableStatement cstmt = con.prepareCall("{call FINDREGISTER(?, ? ,? )}");
		// Setting the value for the TN parameter
		cstmt.setString(1, input.getUsername());
		cstmt.setString(2, input.getPassword());
		cstmt.registerOutParameter(3, Types.VARCHAR);

		// Executing the CallableStatement
		cstmt.executeUpdate();
		// Retrieving the values for product name, customer name and, price
		String username = cstmt.getString(3);
		RegisterModel model = new RegisterModel();
		model.setUsername(username);
		
		
		
		return model;
	}

}
