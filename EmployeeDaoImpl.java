package com.crudoperation.cruapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con;

	@Override
	public void createEmployee(employee emp) {
		con = DBconnection.createDBConnection();
		String query = "insert into employee values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, emp.getId());
			pstm.setDouble(2, emp.getSalary());
			pstm.setInt(3, emp.getAge());
			pstm.setString(4, emp.getName());

			int cnt = pstm.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee inserted Successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void showAllEmployee() {
		con = DBconnection.createDBConnection();
		String query = "select* from employee";
		System.out.println("Employee Details");
		System.out.format("%s\t%s\t%s\t%s\n", "id","salary", "age", "name");
		
		try {
			Statement stmt = con.createStatement();
			ResultSet result =(ResultSet) stmt.executeQuery(query);
			while(((java.sql.ResultSet) result). next()) {
				System.out.format("%d\t%.0f\t%d\t%s\n", result.getInt(1),((ResultSet) result).getDouble(2),result.getInt(3),result.getString(4));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		con = DBconnection.createDBConnection();
		String query= "select * from employee where id=" +id;
		try { 
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(((java.sql.ResultSet) result). next()) {
				System.out.format("%d\t%.0f\t%d\t%s\n", result.getInt(1),((ResultSet) result).getDouble(2),result.getInt(3),result.getString(4));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void updateEmployee(int id, String name) {
		con = DBconnection.createDBConnection();
		String query ="update employee  set name=?, where id=?";

			try {
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1, name);
				pstm.setInt(2, id);
				int cnt=pstm.executeUpdate();
				if(cnt!=0) {
					System.out.println("Employee Details Updated Successfully");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}

	@Override
	public void deleteEmployee(int id) {
		con = DBconnection.createDBConnection();
		String query="delete from employee where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1,id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee Deleted Successfully"+id);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
