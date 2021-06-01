package com.lucien.EmployeeRegister.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucien.EmployeeRegister.dao.DepartmentDao;
import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	@Transactional
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	@Transactional
	public Department findById(int id) {
		return departmentDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		departmentDao.deleteById(id);
	}

	@Override
	@Transactional
	public void addUser(Department department, User user) {
		department.addUser(user);
		departmentDao.save(department);
	}

	@Override
	@Transactional
	public void removeUser(Department department, User user) {
		department.removeUser(user);
		departmentDao.save(department);
	}

}
