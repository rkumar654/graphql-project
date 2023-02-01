package com.mrk.graphql.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode
public class Project implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838716353463876558L;

	@Id
	@Column(name = "ID",nullable = false,length = 1000)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="OWNER")
	private String owner;
	@Column(name="TECH_LEAD")
	private String techinalLead;
	
	@Column(name="TEAM_LEAD")
	private String teamLead;
	
	@Column(name="NO_OF_RESOUCES")
	private int noOfResouces; 
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE ")
	private String endDate;
}
