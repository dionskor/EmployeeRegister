package com.lucien.EmployeeRegister.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucien.EmployeeRegister.dao.UserDao;
import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public User findById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	@Transactional
	public void addDepartment(User user, Department department) {
		user.addDepartment(department);
		userDao.save(user);
	}

	@Override
	@Transactional
	public void removeDepartment(User user, Department department) {
		user.removeDepartment(department);
		userDao.save(user);
	}

}
