package com.lucien.EmployeeRegister.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucien.EmployeeRegister.model.User;
import com.lucien.EmployeeRegister.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getAllUsers(Model model) {
		List<User> users = userService.findAll();

		model.addAttribute("users", users);

		return "users/users";
	}

	@GetMapping("/addUserForm")
	public String getUserForm(Model model) {
		User user = new User();

		model.addAttribute(user);

		return "users/user_form";
	}

	@GetMapping("/updateUserForm")
	public String updateUserForm(@RequestParam("userId") int userId, Model model) {

		User user = userService.findById(userId);

		model.addAttribute(user);

		return "users/user_form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);

		return "redirect:/users/";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		userService.deleteById(userId);

		return "redirect:/users/";
	}

}
