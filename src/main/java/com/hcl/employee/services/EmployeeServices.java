package com.hcl.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.DAO.EmployeeDAO;
import com.hcl.employee.beans.Employee;
import com.hcl.employee.util.UserInputException;
@Service
public class EmployeeServices {
	@Autowired
	private EmployeeDAO ed;
	public  List<Employee> displayEmployee(){
		
		return ed.displayEmployee();
	}

	public  Employee addEmployee(Employee employee) throws UserInputException {
		
		// TODO Auto-generated method stub
		return ed.addEmployee(employee);
	}
	public  void updateEmployee(Employee employee) throws UserInputException{
		
		ed.updateEmployee(employee);
	}
	public  void deleteEmployee(int emp_id) throws UserInputException {
		
		ed.deleteEmployee(emp_id);
		
	}
	public  List<Employee> searchEmployee(int emp_id) throws UserInputException{
		
		return ed.searchEmployee(emp_id);
	}

}
