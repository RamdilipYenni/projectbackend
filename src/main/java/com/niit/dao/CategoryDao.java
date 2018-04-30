package com.niit.dao;
import java.util.List;
import com.niit.model.*;
public interface CategoryDao 
{
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}
