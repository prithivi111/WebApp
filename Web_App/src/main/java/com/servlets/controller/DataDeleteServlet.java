package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dbconnectivity.StudentServiceClass;


@WebServlet("/delete")
public class DataDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int deleteStatus = StudentServiceClass.datadelete("Sagar");
			if(deleteStatus > 0) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1>Data has been deleted successfully</h1>");
				
			}else {
				PrintWriter out = response.getWriter();
				out.println("<h1>Data has not been deleted. Do check!!</h1>");
			}
		
	}
}

