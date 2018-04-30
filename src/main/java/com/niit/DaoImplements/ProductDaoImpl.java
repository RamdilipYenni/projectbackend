package com.niit.DaoImplements;
import java.util.List;
import com.niit.dao.*;
import com.niit.model.*;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().save(product);
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
	public boolean updateProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
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
	public boolean deleteProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().delete(product);
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
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		session.close();
		return product;
	}

	@Transactional
	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listProducts = query.list();
		session.close();
		return listProducts;
	}

}