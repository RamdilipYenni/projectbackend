package com.niit.dao;
import java.util.List;
import com.niit.model.*;

public interface CustomerDao
{
	public boolean addCustomer(Customer customer);
	public boolean upadteCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public List<Customer> listCustomer();
	static List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	boolean updateCustomer(Customer customer);
	static Customer getCustomer(String customerid) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateCustomer(CustomerDao customerDao);
	Customer getCustomer(int customerId);
	boolean getCustomer(Customer customerId);
}