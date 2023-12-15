package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dbconnectivity.StudentServiceClass;


@WebServlet("/update")
public class DataUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int updateStatus = StudentServiceClass.dataupdate();
			if(updateStatus == 1) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1>Data has been updated successfully<h1>");
				
			}else {
				PrintWriter out = response.getWriter();
				out.println("Data has not been updated. Do check!!");
			}
		
	}
}
