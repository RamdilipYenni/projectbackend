package com.niit.DaoImplements;

import com.niit.dao.*;
import com.niit.model.*;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository("CartDao")
public class CartDaoImpl implements CartDao
{
@Autowired
SessionFactory sessionFactory;

@Transactional
@Override
public boolean addToCart(Cart cart) {
	try 
	{
	sessionFactory.getCurrentSession().save(cart);
	return true;
	}
	catch(Exception e) 
	{
	System.out.println("Exception Arised"+e);
	return false;
	}
	}

@Transactional
@Override
public boolean deleteFromCart(Cart cart) 
{
try
   {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}
	
	}

	@Transactional
	@Override
	public boolean updateFromCart(Cart cart) {
		try 
		{
		sessionFactory.getCurrentSession().update(cart);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}			
	}

	@Transactional
	@Override
	public List<Cart> listCartItems() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		List<Cart> listCartItems = query.list();
		session.close();
		return listCartItems;
		}

	@Transactional
	@Override
	public Cart getCart(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	@Override
	public List<Cart> listCartItems(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}