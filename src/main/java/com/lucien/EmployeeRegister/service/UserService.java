package com.lucien.EmployeeRegister.service;

import java.util.List;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

public interface UserService {

	public List<User> findAll();

	public User findById(int userId);

	public void save(User user);

	public void deleteById(int id);

	public void addDepartment(User user, Department department);

	public void removeDepartment(User user, Department department);

}
