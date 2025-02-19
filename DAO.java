package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO 
{
	public static final String url="jdbc:mysql://localhost:3306/StudentData";
	public static final String username="root";
	public static final String password="Nagawadet@123";
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public static int saveDetails(Student s) throws ClassNotFoundException, SQLException
	{
		Connection con=DAO.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into stud(first_name,last_name,email,password,contact,gender) values(?,?,?,?,?,?)");
		pst.setString(1, s.getFname());
		pst.setString(2, s.getLname());
		pst.setString(3, s.getEmail());
		pst.setString(4, s.getPassword());
		pst.setString(5, s.getMob());
		pst.setString(6, s.getGender());
		int status=pst.executeUpdate();
		return status;
	}
}
