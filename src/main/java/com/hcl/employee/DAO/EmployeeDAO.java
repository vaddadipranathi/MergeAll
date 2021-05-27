package com.hcl.employee.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.util.ConnectionUtil;
import com.hcl.employee.util.UserInputException;

@Repository
public class EmployeeDAO {
	public static JdbcTemplate template=ConnectionUtil.getConnection();
	public  Employee addEmployee(Employee employee) throws UserInputException {
		
		if(!searchById(employee.getEmp_id())) {
		
		
		String sql="insert into Employee values(?,?,?)";
		template.update(sql,employee.getEmp_id(),employee.getEmp_name(),employee.getEmp_address());
		return employee;
		}
		else
		{
			throw new UserInputException("Id already exists");
		}
	}
	public  void updateEmployee(Employee employee) throws UserInputException {
		if(searchById(employee.getEmp_id())) {
			
			String sql="update employee set emp_name=?, emp_address=? where emp_id=?";
			template.update(sql,employee.getEmp_name(),employee.getEmp_address(),employee.getEmp_id());
		}
		else
		{
			throw new UserInputException("Id doesn't exists");
		}
	}
	public  void deleteEmployee(int emp_id) throws UserInputException {
		if(searchById(emp_id)) {
			
			String sql="delete from employee where emp_id=?";
			template.update(sql,emp_id);
		}
		else
		{
			throw new UserInputException("Id doesn't exists");
		}
	}
	
	
	public  List<Employee> searchEmployee(int emp_id) throws UserInputException{
		if(searchById(emp_id)) {
			
			String sql="select emp_id,emp_name,emp_address from employee where emp_id=?";
			List<Employee> list=template.query(sql,new EmployeeMapper(),emp_id);
			return list;
		}
		else
		{
			throw new UserInputException("Id doesn't exists");
		}		
	}
	public  List<Employee> displayEmployee() {
		
		List<Employee> emp=new ArrayList<Employee>();
		String sql="select emp_id,emp_name,emp_address from employee";
		return template.query(sql, new EmployeeMapper());
	}
	public static boolean searchById(int emp_id)
    {
		
		String sql="select emp_id,emp_name,emp_address from employee where emp_id=?";
		List<Employee> list=template.query(sql,new EmployeeMapper(),emp_id);
		if(list.size()==0)
			return false;
		else
			return true;
		
    }

}
