package com.mrk.graphql.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode
public class Employee implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4184624261107776756L;

	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(name="EMP_NAME",nullable = false)
	private String empName;
	
	@Column(name="MAIL_ID",nullable = false)
	private String emailId;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="PROJECT_ID")
	private String projectId;
	
	@Column(name="STACK")
	private String stack;
}
