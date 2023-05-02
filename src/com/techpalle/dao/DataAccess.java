package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class DataAccess 
{
	private static final String driverPath="com.mysql.cj.jdbc.Driver";
	private static final String dbUrl="jdbc:mysql://localhost:3306/palle";
	private static final String dbUsername="root";
	private static final String dbPassword="aryan";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into customer(name,email,mobile,dbPassword,state) values(?,?,?,?,?)";
	
	private static final String validateQry="select email,password from customer where email=? and password=?";
	
	public static boolean validateCustomer(String email,String password) 
	{
		boolean row=false;
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps= con.prepareStatement(validateQry);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs= ps.executeQuery();

			row=rs.next();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	public static void insertCustomer (Customer customer)
	{
		try
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps=con.prepareStatement(insertQry);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getState());
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (ps!=null) 
				{
					ps.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}