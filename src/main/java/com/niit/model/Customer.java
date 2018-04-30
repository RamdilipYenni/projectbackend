package com.niit.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.niit.dao.CustomerDao;

@Entity
@Table
public class Customer implements CustomerDao {

	@Id
	@GeneratedValue
	private int customerId;
	
	private String customerName;
	private String customerAddress;
	
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getcustomerName() {
		return customerName;
	}
	public static void setcustomerName(String customerName) {
		customerName = customerName;
	}
	public String customerAddress() {
		return customerAddress;
	}
	public static void setcustomerAddress(String customerAddress) {
		customerAddress = customerAddress;
	}
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean upadteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getCustomer(Customer customerId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateCustomer(CustomerDao customerDao) {
		// TODO Auto-generated method stub
		
	}
	public static Customer getCustomer(String customerid) {
		customerid = customerid;
		return null;
	}
	
	
}