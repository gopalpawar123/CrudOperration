package com.crudoperation.cruapp;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int id;
		String name;
		EmployeeDao dao = new EmployeeDaoImpl();
		System.out.println("Welcome to employee management application");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Add Employee\n" + "2.Show All employee\n" + "3.Show Employee based on id \n"
					+ "4.Update employee \n" + "5. Delete employee");
		System.out.println("Enter choice");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			employee emp = new employee();
			System.out.println("Enter Id:");
			 id = sc.nextInt();
			System.out.println("Enter salary:");
			double salary = sc.nextDouble();
			System.out.println("Enter age:");
			int age = sc.nextInt();
			System.out.println("Enter name:");
			 name = sc.next();
			emp.setId(id);
			emp.setSalary(salary);
			emp.setAge(age);
			emp.setName(name);
			dao.createEmployee(emp);
			break;
		case 2:
			dao.showAllEmployee();
			break;
		case 3:
			System.out.println("Enter id to show the details");
			int empid = sc.nextInt();
			dao.showEmployeeBasedOnId(empid);
			break;
		case 4:
			System.out.println("Enter id to update the details");
			id = sc.nextInt();
			System.out.println("Enter the new name");
			 name = sc.next();
			dao.updateEmployee(id, name);
			break;
		case 5:
			System.out.println("Enter the id to delete");
			  id = sc.nextInt();
				dao.deleteEmployee(id);

		case 6:
			System.out.println("thank you for using our Apllication !!!");
			System.exit(0);
			default:
				System.out.println("Enter valid choice");
		}
		} while (true);
	}

}
