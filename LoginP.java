package com.org.gen.day16;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginP
 */
@WebServlet("/LoginP")
public class LoginP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost/login";
	    response.setContentType("text/html");
	    String msg = " ";

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Ashish@7386");  

	       
	        Statement st1 = conn.createStatement();
	        ResultSet rs = st1.executeQuery("select * from user  WHERE username='"
	                + username + "' and password='" + password + "'");
	        if (rs.next()) {
	            msg = "HELLO" + username + "! Your login is SUCESSFULL";
	            
				

	        } else {
	            msg = "HELLO" + username + "!Your login is UNSUCESSFULL";
	        }
	        rs.close();
	        st1.close();
	       
	        PrintWriter out = response.getWriter();
	        out.println("test :" + msg);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
