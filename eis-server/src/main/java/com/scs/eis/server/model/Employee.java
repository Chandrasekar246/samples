package com.scs.eis.server.model;

import java.util.Date;

public class Employee {

	private String id;
	private String name;
	private Date joiningDate;
	private String department;
	

	public Employee(String id, String name, Date joiningDate, String department) {
		this.id = id;
		this.name = name;
		this.joiningDate = joiningDate;
		this.department = department;
	}

	public Employee() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}