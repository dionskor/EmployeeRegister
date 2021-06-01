package com.lucien.EmployeeRegister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucien.EmployeeRegister.model.Department;
import com.lucien.EmployeeRegister.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/")
	public String getAllDepartments(Model model) {

		model.addAttribute("departments", departmentService.findAll());

		return "departments/departments";
	}

	@GetMapping("/addDepartmentForm")
	public String getDepartmentForm(Model model) {
		Department department = new Department();

		model.addAttribute(department);

		return "departments/department_form";
	}

	@GetMapping("/updateDepartmentForm")
	public String updateDepartmentForm(@RequestParam("departmentId") int departmentId, Model model) {

		Department department = departmentService.findById(departmentId);

		model.addAttribute(department);

		return "departments/department_form";
	}

	@PostMapping("/save")
	public String saveDepartment(@ModelAttribute("department") Department department) {
		departmentService.save(department);

		return "redirect:/departments/";
	}

	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("departmentId") int departmentId) {
		departmentService.deleteById(departmentId);

		return "redirect:/departments/";
	}
}
