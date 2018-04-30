package com.niit.dao;
import java.util.List;
import com.niit.model.*;

public interface CartDao {
	public boolean addToCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public boolean updateFromCart(Cart cart);
	public Cart getCart(int cartId);
	public List<Cart> listCartItems();
	public List<Cart> listCartItems(String username);
}