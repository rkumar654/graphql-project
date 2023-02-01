package com.mrk.graphql.quary.componets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrk.graphql.entites.Employee;
import com.mrk.graphql.entites.Project;
import com.mrk.graphql.exceptions.EmployeeNotFoundException;
import com.mrk.graphql.service.EmployeeService;

import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class EmployeeQuery  implements GraphQLQueryResolver{

	
	
	@Autowired
	private EmployeeService employeeService;
	
	public List<Employee> getEmployees(final int count) {
		return employeeService.fetchEmpoyees(count);
	}
	
	public Employee getEmployee(int id) {
		return this.employeeService.fetchEmployeeById(id).orElseThrow(EmployeeNotFoundException::new);
	}
	
	public List<Employee> getEmployeeByName(String empName){
		return this.employeeService.fetchEmployeeByName(empName);
	}
	
	public Project getProject(String id) {
		return new Project();
	}
}
