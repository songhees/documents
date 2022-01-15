package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.DepartmentDao;
import com.sample.dao.LocationDao;
import com.sample.dto.DepartmentListDto;
import com.sample.vo.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	LocationDao locationDao;
	
	public List<DepartmentListDto> getAllDepartment() {
		return departmentDao.getAllDepartments();
	}
	
	public Department getDepartmentById(int id) {
		return departmentDao.getDepartmentById(id);
	}
	
	public void addDepartment(Department department) {
		departmentDao.insertDepartment(department);
	}
	
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}
	
}
