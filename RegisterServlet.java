package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/servlet1")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mob=request.getParameter("mobile");
		String gender=request.getParameter("gender");
		
		Student s=new Student();
		s.setFname(fname);
		s.setLname(lname);
		s.setEmail(email);
		s.setPassword(password);
		s.setMob(mob);
		s.setGender(gender);
		
		int status = 0;
		try {
			status = DAO.saveDetails(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status>0)
		{
			out.print("<h2>Record Inserted Successfully!!!!</h2>");
//			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			out.print("<h2>Something Went Wrong, Please Try Again!!!</h2>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
	}
}
