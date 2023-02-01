package com.mrk.graphql.quary.componets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrk.graphql.entites.Employee;
import com.mrk.graphql.service.EmployeeService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class EmployeeMutation implements GraphQLMutationResolver{

	@Autowired
	private EmployeeService employeeService;
	
	public Employee save(final String name,final String emailid,
			final String role, final String projectId, final String stack) {
		return this.employeeService.save(name, emailid, role, projectId, stack);
	}
}
