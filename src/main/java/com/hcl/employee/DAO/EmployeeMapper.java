package com.hcl.employee.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.employee.beans.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.setEmp_id(rs.getInt(1));
		e.setEmp_name(rs.getString(2));
		e.setEmp_address(rs.getString(3));
		return e;
	}

}
