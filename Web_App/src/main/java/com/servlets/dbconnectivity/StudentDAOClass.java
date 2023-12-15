package com.servlets.dbconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOClass {
	
	//Here we are trying to insert the data into the SQL.
	public int datasaveintoSQL (StudentClass std) throws SQLException {
		int count =0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "insert into student (name, address, mobile, email, password, cPassword)" + "values (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, std.getName());
			ps.setString(2, std.getAddress());
			ps.setInt(3, std.getMobile());
			ps.setString(4, std.getEmail());
			ps.setString(5, std.getPassword());
			ps.setString(6, std.getcPassword());
			
			count = ps.executeUpdate();
			
			if(count==1) {
				System.out.println("Data entered successfully.");
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Name", "Address", "Mobile", "Email", "Password", "cPassword");
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", std.getName(), std.getAddress(), std.getMobile(),std.getEmail(),
						    std.getPassword(), std.getcPassword());
			}		
			ps.close();
			conn.close();
					
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
			
		return count;
	}

	//Here we are trying to fetch the data directly from SQL and storing into ArrayList, which goes back to ServletClass to display on the browser.
	public List<StudentClass> datafetchfromSQL() throws SQLException {
	
		List<StudentClass> stdList = new ArrayList<StudentClass>();		
		try {	
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from student";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentClass std = new StudentClass();
				std.setName(rs.getString(1));
				std.setAddress(rs.getString(2));
				std.setMobile(rs.getInt(3));
				std.setEmail(rs.getString(4));
				std.setPassword(rs.getString(5));
				std.setcPassword(rs.getString(6));
				
				stdList.add(std);
			}
			
			System.out.println("All data successfully fetched from the SQL.");
			System.out.println("Now you'll be able to see the SQL table on the browser.");
			
			ps.close();
			conn.close();		
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
		return stdList;
	}
	
	//Here we are trying to update the data in the SQL and then display the result on the browser with the updated result.
	public static int dataupdateintoSQL () throws SQLException {
		int count =0;
		try {
			String newAddress = "Thamel";
			String email = "suraj123gmail.com";
			
			Connection conn = DatabaseConnection.getConnection();
			String sql = "update student set address=? where email=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newAddress);
			ps.setString(2, email);
			
			count = ps.executeUpdate();
			
			if(count==1) {
				System.out.println("Data has been updated successfully.");
				System.out.println("You'll be able to see the updated SQL table (after update) table on the browser.");
			}
			
			ps.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
			
		return count;
	}
	
	//Here we are trying to delete the data in the SQL and then display the result on the browser with the updated result.
	public static int datadeletefromSQL(String name) {
		int count = 0;
		try{
			Connection conn = DatabaseConnection.getConnection();
			String sql ="delete from student where name=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name );
			
			count = ps.executeUpdate();
			
			if(count == 1) {
					System.out.println("Data has been deleted successfully.");
					System.out.println("You'll be able to see the updated SQL table (after deletion) on the browser.");
				}
			
			conn.close();
			ps.close();
			
		}catch (Exception e){
			e.printStackTrace();

		}
		
		return count;	
	}
	
}
	
	/*
	 * public StudentClass getStudentByName (String nameFetch) {
	 * 
	 * StudentClass std = new StudentClass(); 
	 * try { 
	 * Connection conn = DatabaseConnection.getConnection(); 
	 * String sql = "select * from student where name=?";
	 * PreparedStatement ps =conn.prepareStatement(sql); 
	 * ps.setString(1, nameFetch);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * if(rs.next()) { //setting object values from resultset
	 * 
	 * std.setName(rs.getString(1));
	 * std.setAddress(rs.getString(2));
	 * std.setMobile(rs.getInt(3));
	 * std.setEmail(rs.getString(4));
	 * std.setPassword(rs.getString(5));
	 * std.setcPassword(rs.getString(6));
	 * 
	 * conn.close();
	 * ps.close(); }
	 * 
	 * } catch (Exception e){
	 *  e.printStackTrace();
	 * 
	 * } 
	 * return std;
	 * }
	 */
	
