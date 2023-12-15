package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dbconnectivity.StudentClass;
import com.servlets.dbconnectivity.StudentServiceClass;


@WebServlet("/insert")
public class DataInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cPassowrd = request.getParameter("cPassword");
		
		StudentClass student = new StudentClass();
		student.setName(name);
		student.setAddress(address);
		student.setMobile(mobile);
		student.setEmail(email);
		student.setPassword(password);
		student.setcPassword(cPassowrd);
		
		//We are inserting the student details in the SQL 
		StudentServiceClass.datainsert(student);
		
		try {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>");
		out.println("Data inserted Successfully");
		out.println("</h1>");	
		out.println("<h2>");
		out.printf("%-40s%-40s%-40s%-40s%-40s%-40s%n", "Name", "Address", "Mobile", "Email", "Password", "cPassword");
		out.println("</h2>");

		out.printf("%-40s%-40s%-40s%-40s%-40s%-40s%n", student.getName(), student.getAddress(), student.getMobile(),student.getEmail(),
				    student.getPassword(), student.getcPassword());
		
		}catch(Exception e) {
			System.out.println("Error Details: "+e.getMessage());
		}
	}

}

