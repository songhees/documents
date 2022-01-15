package com.sample.form;

import com.sample.vo.Department;

public class DepartmentInsertForm {

	private String name;
	private int locationId;
	
	public DepartmentInsertForm() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public Department toDepartment() {
		Department department = new Department();
		department.setName(name);
		department.setLocationId(locationId);
		return department;
	}

	@Override
	public String toString() {
		return "DepartmentInsertForm [name=" + name + ", locationId=" + locationId + "]";
	}
	
}
