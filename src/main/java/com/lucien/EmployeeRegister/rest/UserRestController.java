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
@RequestMapping("/api/users/")
public class UserRestController {
	private UserService userService;

	private DepartmentService departmentService;

	public UserRestController(UserService userService, DepartmentService departmentService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public List<User> getallUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		user.setId(0);

		userService.save(user);

		return user;
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User user) {

		return user;
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteById(id);

		return "Deleted user id -" + id;
	}

	@PostMapping("/{userId}/departments/{departmentId}")
	public User addDepartment(@PathVariable("userId") int userId, @PathVariable("departmentId") int departmentId) {
		User user = userService.findById(userId);
		Department department = departmentService.findById(departmentId);
		userService.addDepartment(user, department);

		return user;
	}

	@DeleteMapping("/{userId}/departments/{departmentId}")
	public User removeDeparment(@PathVariable("userId") int userId, @PathVariable("departmentId") int departmentId) {
		User user = userService.findById(userId);
		Department department = departmentService.findById(departmentId);
		userService.removeDepartment(user, department);

		return user;
	}

}
