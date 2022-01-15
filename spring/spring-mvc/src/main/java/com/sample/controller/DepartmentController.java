package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.dao.LocationDao;
import com.sample.form.DepartmentInsertForm;
import com.sample.service.DepartmentService;
import com.sample.service.EmployeeService;
import com.sample.vo.Department;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	LocationDao locationDao;

	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartment());
		return "dept/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form(Model model) {
		model.addAttribute("locations", locationDao.getAllLocations());
		return "dept/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(DepartmentInsertForm insertForm) {
		departmentService.addDepartment(insertForm.toDepartment());
		return "redirect:list.do";
	}
	
	@GetMapping("/modify.do")
	public String formForm(int id, Model model) {
		model.addAttribute("department", departmentService.getDepartmentById(id));
		model.addAttribute("locations", locationDao.getAllLocations());
		model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(id));
		return "dept/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(Department department) {
		departmentService.updateDepartment(department);
		return "redirect:list.do";
	}
	
}
