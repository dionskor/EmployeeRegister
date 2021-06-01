package com.lucien.EmployeeRegister.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;

@Repository
public class DepartmentDaoHibernateImpl implements DepartmentDao {

	private EntityManager entityManager;

	public DepartmentDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Department> findAll() {
		// gett the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<Department> query = currentSession.createQuery("from Department ", Department.class);
		// execute query and get result list
		List<Department> departments = query.getResultList();
		// return the results
		return departments;
	}

	@Override
	public Department findById(int departmentId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// get the User
		Department department = currentSession.get(Department.class, departmentId);
		return department;
	}

	@Override
	public void save(Department department) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save Department
		currentSession.saveOrUpdate(department);
	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Department where id=:departmentId");
		query.setParameter("departmentId", id);

		query.executeUpdate();

	}

	public void addUser(Department department, User user) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save Department
		currentSession.saveOrUpdate(user);
	}

	public void removeUser(Department depatment, User user) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save Department
		currentSession.saveOrUpdate(user);
	}

}
