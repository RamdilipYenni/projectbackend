package com.niit.dao;
import com.niit.model.*;
public interface UserDao 
{
	public static  boolean registerUser(User user)
	{
		return false;
	}
	public static boolean updateUser(User user) 
	{
		return false;
	}
	public static User getUser(String userName) 
	{
		return null;
	}
	public static boolean approveUser(User user)
	{
		return false;
	}
}
