package com.mrk.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrk.graphql.entites.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByEmpName(String name);
}
