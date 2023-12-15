package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dbconnectivity.StudentClass;
import com.servlets.dbconnectivity.StudentServiceClass;

@WebServlet("/fetchanddisplay")
public class DataDisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<StudentClass> stdList = new ArrayList<StudentClass>();
				stdList = StudentServiceClass.datadisplay();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				out.println("<table border='1'>");
				
					out.println("<tr>");
				
						out.println("<th>");
						out.println("<h3>name</h3>");
						out.println("</th>");
				
						out.println("<th>");
						out.println("<h3>address</h3>");
						out.println("</th>");
				
						out.println("<th>");
						out.println("<h3>mobile</h3>");
						out.println("</th>");
				
						out.println("<th>");
						out.println("<h3>email</h3>");
						out.println("</th>");
				
						out.println("<th>");
						out.println("<h3>password</h3>");
						out.println("</th>");
				
						out.println("<th>");
						out.println("<h3>cpassword</h3>");
						out.println("</th>");
						out.println("</tr>");
				
							for(StudentClass ls: stdList) {
								out.println("<tr>");
					
									out.println("<td>");
									out.println(ls.getName());
									out.println("</td>");
					
									out.println("<td>");
									out.println(ls.getAddress());
									out.println("</td>");
					
									out.println("<td>");
									out.println(ls.getMobile());
									out.println("</td>");
					
									out.println("<td>");
									out.println(ls.getEmail());
									out.println("</td>");
					
									out.println("<td>");
									out.println(ls.getPassword());
									out.println("</td>");
					
									out.println("<td>");
									out.println(ls.getcPassword());
									out.println("</td>");
									out.println("</tr>");
								}
				
							out.println("</table>");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
