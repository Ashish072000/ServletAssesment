package com.org.gen.day16;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name =request.getParameter("val1");
		String userid =request.getParameter("val2");
		String pass =request.getParameter("val3");
		String c = request.getParameter("val4");
		String coun=request.getParameter("val5");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Ashish@7386");

			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?)");

			ps.setString(1,name);
			ps.setString(2,userid);
			ps.setString(3,pass);
			ps.setString(4,c);
			ps.setString(5,coun);

			int i=ps.executeUpdate();
			if(i>0)
			pw.print("You are successfully registered...");
			

			System.out.println("test");
			}catch (Exception e2) {System.out.println(e2);}

			pw.close();
			}

}
	


