package com.lucien.EmployeeRegister.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

@Repository
public class UserDaoHibarnateImpl implements UserDao {

	private EntityManager entityManager;

	public UserDaoHibarnateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAll() {
		// gett the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<User> query = currentSession.createQuery("from User", User.class);
		// execute query and get result list
		List<User> users = query.getResultList();
		// return the results
		return users;
	}

	@Override
	public User findById(int userId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// get the User
		User user = currentSession.get(User.class, userId);
		return user;
	}

	@Override
	public void save(User user) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save User
		currentSession.saveOrUpdate(user);
	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// delete object with primary key
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);

		query.executeUpdate();
	}

	public void addDepartment(User user, Department department) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// add Department to the User
		user.addDepartment(department);
		// save User
		currentSession.saveOrUpdate(user);
	}

	public void removeDepartment(User user, Department department) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// remove Department from the User
		user.removeDepartment(department);
		// save User
		currentSession.saveOrUpdate(user);
	}

}
