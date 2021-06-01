package com.lucien.EmployeeRegister.dao;

import java.util.List;

import com.lucien.EmployeeRegister.model.User;

public interface UserDao {

	public List<User> findAll();

	public User findById(int userId);

	public void save(User user);

	public void deleteById(int id);
}
