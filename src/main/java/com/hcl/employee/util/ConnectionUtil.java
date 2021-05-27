package com.hcl.employee.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {
	public static JdbcTemplate getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch blsock
			e.printStackTrace();
		}  
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean(JdbcTemplate.class);
		
		return jdbcTemplate;
		
	}

}
