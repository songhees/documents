package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EmployeeDao;
import com.sample.dto.EmployeeDetailDto;
import com.sample.dto.EmployeeListDto;
import com.sample.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public List<EmployeeListDto> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	public List<Employee> getAllEmployeesByDepartment(int departmentId) {
		return employeeDao.getAllEmployeesByDepartment(departmentId);
	}
	
	public EmployeeDetailDto getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}
	
	public void addNewEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	
	public List<EmployeeListDto> getAllManagers() {
		return employeeDao.getAllManagers();
	}
}
