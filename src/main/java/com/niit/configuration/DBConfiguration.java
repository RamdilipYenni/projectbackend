package com.niit.configuration;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import javax.sql.DataSource.*;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DaoImplements.*;
import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.*;

@Configurable
@EnableTransactionManagement
public class DBConfiguration {
	
	@Bean(name="DataSource")
	public DataSource getH2Data() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Ramdilip");
		dataSource.setUsername("sa");
		System.out.println("Data Source object created");
		return dataSource;
	}
	
	private Properties getHiber() {
		Properties p = new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		System.out.println("Tables Created");
		return p;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession(){
		 
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(getH2Data());
		lsfb.addProperties(getHiber());
		
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Customer.class);
		lsfb.addAnnotatedClass(Product.class);
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Cart.class);
		
		SessionFactory sessionFactory= lsfb.buildSessionFactory();	
		System.out.println("SessionFactory object created");
		return sessionFactory;
	}
	
	@Bean(name="categoryDao")
	public CategoryDao getCategoryDao() 
	{
		return new CategoryDaoImpl();
	}
	
	@Bean(name="productDao")
	public ProductDao getProductDao()
	{
		return new ProductDaoImpl();
	}
	
	@Bean(name="CustomerDao")
	public CustomerDao getCustomerDao()
	{
		return new CustomerDaoImpl();
	}
	
	@Bean(name="userDao")
	public UserDao getUserDao() 
	{
		return new UserDaoImpl();
	}

	@Bean(name="cartDao")
	public CartDao getCartDao() 
	{
		return new CartDaoImpl();
	}

	@Bean
	public HibernateTransactionManager getHibernateSessionFactory(SessionFactory sessionFactory) {
		 
	    System.out.println("Hibernate Transaction Manager object created");
		return new HibernateTransactionManager(sessionFactory);
			
	}
}