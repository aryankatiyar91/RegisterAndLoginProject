package com.techpalle.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		
		switch(path)
		{
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		case "/log":
			getLoginPage(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the email and password from login.jsp page
		String email= request.getParameter("tbEmailLog");
		String pass= request.getParameter("tbPassLog");
		
		//call the method present in DAO
		boolean res= DataAccess.validateCustomer(email, pass);
		
		//Condition and redirect user to success page
		if(res)
		{
			try 
			{
				RequestDispatcher rd  = request.getRequestDispatcher("success.jsp");
				// Store the successPege class data inside rd
				SuccessPage sp=new SuccessPage();
				request.setAttribute("successDetails", sp);	// Always write this after requestDispatcher rd code not before that
				
				rd.forward(request, response);
			} 
			catch (ServletException | IOException e ) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			getLoginPage(request,response);
		}
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the data from jsp page
		String name= request.getParameter("tbName");
		String email= request.getParameter("tbEmail");
		long mobile= Long.parseLong(request.getParameter("tbMobile"));
		String pass= request.getParameter("tbPass");
		String state= request.getParameter("ddlStates");
		
		// Add above data to customer object:
		Customer cust = new Customer(name, email, mobile, pass, state);
		
		//Call the insertCustomer method and pass the above values as input
		DataAccess.insertCustomer(cust);
		
		//Redirect user to login page with email and password
		try 
		{
			RequestDispatcher rd  = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e ) 
		{
			e.printStackTrace();
		}
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd  = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e ) 
		{
			e.printStackTrace();
		}
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd  = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e ) 
		{
			e.printStackTrace();
		}
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd  = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e ) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}