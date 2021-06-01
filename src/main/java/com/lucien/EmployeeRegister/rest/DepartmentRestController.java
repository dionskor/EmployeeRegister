package com.lucien.EmployeeRegister.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.model.User;
import com.lucien.EmployeeRegister.service.DepartmentService;
import com.lucien.EmployeeRegister.service.UserService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {
	private DepartmentService departmentService;
	private UserService userService;

	public DepartmentRestController(DepartmentService departmentService, UserService userService) {
		this.departmentService = departmentService;
		this.userService = userService;
	}

	@GetMapping("/")
	public List<Department> getAllDepartments() {
		return departmentService.findAll();
	}

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable int id) {

		Department department = departmentService.findById(id);
		if (department == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}

		return department;
	}

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		departmentService.save(department);

		return department;
	}

	@PutMapping("/{id}")
	public void updateDepartment(@PathVariable int id, @RequestBody Department department) {
		departmentService.save(department);
	}

	@PostMapping("/{departmentId}/users/{userId}")
	public Department addUser(@PathVariable("departmentId") int departmentId, @PathVariable("userId") int userId) {
		Department department = departmentService.findById(departmentId);
		User user = userService.findById(userId);
		departmentService.addUser(department, user);

		return department;
	}

	@DeleteMapping("/{departmentId}/users/{userId}")
	public Department removeUser(@PathVariable("departmentId") int departmentId, @PathVariable("userId") int userId) {
		Department department = departmentService.findById(departmentId);
		User user = userService.findById(userId);
		departmentService.removeUser(department, user);

		return department;
	}

}
