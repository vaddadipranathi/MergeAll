package com.hcl.employee.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.exception.IdException;
import com.hcl.employee.service.EmployeeServices;

@Controller
public class EmployeeController {
	@Autowired
    private EmployeeServices es;
    @GetMapping("/displayAll")
    public ModelAndView displayEmployee()
    {
        ArrayList<Employee> list=es.displayEmployees();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("list",list);
        return mv;
    }
    @GetMapping("/addEmployee")
    public ModelAndView addEmployee(@RequestParam("id")String id,
    		@RequestParam("name")String name,
    		@RequestParam("department")String department,
    		@RequestParam("salary")String salary,
    		RedirectAttributes redirectAttribute) 
    {
    	Employee e = new Employee();
    	e.setId(Integer.parseInt(id));
    	e.setName(name);
    	e.setDepartment(department);
    	e.setSalary(Float.parseFloat(salary));
    	System.out.println(e);
    	try {
    		es.addEmployee(e);
//    		ArrayList<Employee> list=es.displayEmployees();
    		ModelAndView mv=new ModelAndView("redirect:/displayAll");
    		redirectAttribute.addFlashAttribute("success","Employee added Successfully");
//    		mv.addObject("list",list);
        return mv;
    	}catch(IdException e1) {
    		ArrayList<Employee> list=es.displayEmployees();
    		ModelAndView mv=new ModelAndView("redirect:/displayAll");
//            mv.setViewName("hello");
//            mv.addObject("list",list);
    		redirectAttribute.addFlashAttribute("error","Employee Id already exists cannot add");
            mv.addObject("error",e1.getMessage());
    		e1.printStackTrace();
    		return mv;
    	}
		
    }
    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id")int id,RedirectAttributes redirectAttribute) {
//    	ModelAndView mv=new ModelAndView();
//        mv.setViewName("hello");
//    	ModelAndView mv=new ModelAndView("redirect:/displayAll");
        try {
    		es.deleteEmployee(id);
    		ArrayList<Employee> list=es.displayEmployees();
    		ModelAndView mv=new ModelAndView("redirect:/displayAll");
    		redirectAttribute.addFlashAttribute("success","Employee deleted Successfully");
    		//mv.addObject("list",list);
    		return mv;
    	}catch(IdException e1) {
    		ArrayList<Employee> list=es.displayEmployees();
    		ModelAndView mv=new ModelAndView("redirect:/displayAll");
    		redirectAttribute.addFlashAttribute("error","Employee id doesn't exists");
//            mv.addObject("list",list);
            mv.addObject("error",e1.getMessage());
    		e1.printStackTrace();
    		return mv;
    	}
    }
    @GetMapping("/searchEmployee")
    public ModelAndView searchEmp(@RequestParam("id") int id){
            Employee e=new Employee();               
            try {
                ArrayList<Employee> list=es.searchEmployee(id);
                //List<Employee> list=es.displayEmployee();
                ModelAndView mv=new ModelAndView();
                mv.setViewName("hello");
                mv.addObject("list",list);
                return mv;
            } catch (IdException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                ArrayList<Employee> list=es.displayEmployees();
                ModelAndView mv=new ModelAndView();
                mv.setViewName("hello");
                mv.addObject("list",list);
                mv.addObject("error",e1.getMessage());
                return mv;
            }   
    }
    @GetMapping("/updateEmployee/{id}")
    public ModelAndView updateEmployee(@PathVariable("id") int id) {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("update");
        try {
            mv.addObject("object",es.searchEmployee(id));
        } catch (IdException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }
   
    @GetMapping("/updateEmployee/saveEmployee")
    public ModelAndView updateEmployee(@RequestParam("id")String id,
    		@RequestParam("name")String name,
    		@RequestParam("department")String department,
    		@RequestParam("salary")String salary,RedirectAttributes redirectAttribute){
       
            Employee e=new Employee();
            e.setId(Integer.parseInt(id));
        	e.setName(name);
        	e.setDepartment(department);
        	e.setSalary(Float.parseFloat(salary));
           
            try {
                es.updateEmployee(e);
                ModelAndView mv=new ModelAndView("redirect:/displayAll");
                redirectAttribute.addFlashAttribute("success","Employee updated successfully");
               
                return mv;
            } catch (IdException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                redirectAttribute.addFlashAttribute("error",e1.getMessage());
                ModelAndView mv=new ModelAndView("redirect:/displayAll");
                return mv;
            }   
    }
}
