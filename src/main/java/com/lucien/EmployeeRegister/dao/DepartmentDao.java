package com.lucien.EmployeeRegister.dao;

import java.util.List;

import com.lucien.EmployeeRegister.model.Department;

public interface DepartmentDao {

	public List<Department> findAll();

	public Department findById(int id);

	public void save(Department department);

	public void deleteById(int id);
}
