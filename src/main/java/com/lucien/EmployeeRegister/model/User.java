package com.lucien.EmployeeRegister.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "datetime_created")
	private Date datetimeCreated;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_department", joinColumns = {
			@JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) })
	private List<Department> departments;

	public User() {
	}

	public User(String name, String email, String password, Date datetimeCreated, List<Department> departments) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.datetimeCreated = datetimeCreated;
		this.departments = departments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatetimeCreated() {
		return datetimeCreated;
	}

	public void setDatetimeCreated(Date datetimeCreated) {
		this.datetimeCreated = datetimeCreated;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", datetimeCreated=" + datetimeCreated + ", departments=" + departments + "]";
	}

	public void addDepartment(Department department) {
		this.departments.add(department);
		department.getUsers().add(this);
	}

	public void removeDepartment(Department department) {
		this.departments.remove(department);
		department.getUsers().remove(this);
	}

	public void removeAllDepartments() {
		for (Department department : this.getDepartments()) {
			removeDepartment(department);
		}
	}

}
