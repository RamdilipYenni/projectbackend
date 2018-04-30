package com.niit.DaoImplements;
import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.CustomerDao;
import com.niit.model.*;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addCustomer(Customer customer) {
		
		try 
		{
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println("Exception arised" +e);
			return false;	
		}
		
	}

	@Transactional
	@Override
	public boolean updateCustomer(Customer customer) {
		
		try 
		{
			sessionFactory.getCurrentSession().update(customer);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println("Exception arised" +e);
			return false;	
		}
		
	}

	@Transactional
	@Override
	public boolean deleteCustomer(Customer customer) {
		
		try 
		{
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println("Exception arised" +e);
			return false;	
		}
	}

	@Transactional
	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, customerId);
		session.close();
		return customer;
	}

	@Transactional
	public List<Customer> listCustomers() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Customer> listCustomers = query.list();
		session.close();
		return listCustomers;
	}

	@Override
	public boolean upadteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(CustomerDao customerDao) {
		// TODO Auto-generated method stub
		
	}

	public Customer getCustomer(String customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCustomer(Customer customerId) {
		// TODO Auto-generated method stub
		return false;
	}

}