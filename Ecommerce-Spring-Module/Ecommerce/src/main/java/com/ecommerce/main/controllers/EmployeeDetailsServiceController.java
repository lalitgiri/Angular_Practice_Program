package com.ecommerce.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.EmployeeDetails;
import com.ecommerce.main.service.EmployeeDetailsService;

@RestController
public class EmployeeDetailsServiceController {

	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(method=RequestMethod.POST,value="/addemployee")
	public String addEmployeeDetails(@RequestBody EmployeeDetails employee) throws Exception{
		return employeeDetailsService.addEmployeeDetails(employee);
	}
	@RequestMapping("/deleteemployee/{id}")
	public String deleteEmployeeDetails(@PathVariable int id) {
		return employeeDetailsService.deleteEmployeeDetails(id);
	}
	@RequestMapping
	public Optional<EmployeeDetails> getEmployeeDetails(int id){
		return employeeDetailsService.getEmployeeDetails(id);
	}
	public String updateEmployeeDetails(EmployeeDetails employee,int id) {
		return employeeDetailsService.updateEmployeeDetails(employee, id);
	}
	public List<EmployeeDetails> getAllEmployeeDetails(){
		return employeeDetailsService.getAllEmployeeDetails();
	}
}
