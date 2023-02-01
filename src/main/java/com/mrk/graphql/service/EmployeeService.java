package com.mrk.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrk.graphql.entites.Employee;
import com.mrk.graphql.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public Employee save(String name, String emailId, String role, String projectId, String stack) {
		Employee emp = new Employee();
		emp.setEmpName(name);
		emp.setEmailId(emailId);
		emp.setProjectId(projectId);
		emp.setStack(stack);
		emp.setRole(role);
		return employeeRepository.save(emp);
	}

	@Transactional(readOnly = true)
	public List<Employee> fetchEmpoyees(int count) {
		return employeeRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<Employee> fetchEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> fetchEmployeeByName(String name) {
		return employeeRepository.findByEmpName(name);
	}
}
