package com.crudoperation.cruapp;

public interface EmployeeDao {
	// create employee
	public void createEmployee( employee emp);

//	show all employee
	public void showAllEmployee();

//	show employee based on id
	public void showEmployeeBasedOnId(int id);

//	update employee
	public void updateEmployee(int id, String name);

//	delete employee
	public void deleteEmployee(int id);
}
