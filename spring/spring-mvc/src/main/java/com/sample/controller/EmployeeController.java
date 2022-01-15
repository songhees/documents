package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.form.EmployeeInsertForm;
import com.sample.service.DepartmentService;
import com.sample.service.EmployeeService;
import com.sample.service.JobService;
import com.sample.vo.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	JobService jobService;
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "emp/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		model.addAttribute("departments", departmentService.getAllDepartment());
		model.addAttribute("managers", employeeService.getAllManagers());
		return "emp/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(EmployeeInsertForm insertForm) {
		employeeService.addNewEmployee(insertForm.toEmployee());
		return "redirect:list.do";
	}
	
	@GetMapping("/detail.do")
	public String detail(int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "emp/detail.jsp";
	}
	
	@GetMapping("/modify.do")
	public String modifyform(int id, Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		model.addAttribute("departments", departmentService.getAllDepartment());
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "emp/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:detail.do?id=10";
	}
	
}
