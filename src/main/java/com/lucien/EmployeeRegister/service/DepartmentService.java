package com.lucien.EmployeeRegister.service;

import java.util.List;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

public interface DepartmentService {

	public List<Department> findAll();

	public Department findById(int id);

	public void save(Department department);

	public void deleteById(int id);

	public void addUser(Department department, User user);

	public void removeUser(Department department, User user);

}
