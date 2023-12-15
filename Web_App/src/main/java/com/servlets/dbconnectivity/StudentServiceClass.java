package com.servlets.dbconnectivity;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceClass {

	static StudentDAOClass dao = new StudentDAOClass();
	
	//Data insertion method
	public static void datainsert(StudentClass student) {
		try {
			dao.datasaveintoSQL(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Data fetch and display method
	public static List<StudentClass> datadisplay() {
		List<StudentClass> ls = new ArrayList<StudentClass>();
		try {
			ls = dao.datafetchfromSQL();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	//Data update method
	public static int dataupdate() {
		int updateStatus=0;
		try {
			updateStatus= StudentDAOClass.dataupdateintoSQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateStatus;
	}
	
	//Data delete method
	public static int datadelete(String name) {
		int deleteStatus=0;
		try {
			deleteStatus = StudentDAOClass.datadeletefromSQL(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}
