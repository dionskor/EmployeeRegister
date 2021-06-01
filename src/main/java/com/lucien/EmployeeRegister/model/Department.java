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
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "datetime_created")
	private Date datetimeCreated;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_department", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, updatable = false) })
	private List<User> users;

	public Department() {
	}

	public Department(String name, String description, Date datetimeCreated, List<User> users) {
		this.name = name;
		this.description = description;
		this.datetimeCreated = datetimeCreated;
		this.users = users;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatetimeCreated() {
		return datetimeCreated;
	}

	public void setDatetimeCreated(Date datetimeCreated) {
		this.datetimeCreated = datetimeCreated;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + ", datetimeCreated="
				+ datetimeCreated + "]";
	}

	public void addUser(User user) {
		this.users.add(user);
		user.addDepartment(this);
	}

	public void removeUser(User user) {
		this.users.remove(user);
		user.removeDepartment(this);
	}

	public void removeAllUsers() {
		for (User user : this.users) {
			removeUser(user);
		}
	}

}
