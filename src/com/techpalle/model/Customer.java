package com.techpalle.model;

//Customer Bean class
public class Customer 
{
	private int cId;
	private String name,email,password,state;
	private long mobile;
	
	public Customer(String name, String email, long mobile, String password, String state) 
	{
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.state = state;
	}

	public int getcId() 
	{
		return cId;
	}

	public void setcId(int cId) 
	{
		this.cId = cId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public long getMobile() 
	{
		return mobile;
	}

	public void setMobile(long mobile) 
	{
		this.mobile = mobile;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}
}
