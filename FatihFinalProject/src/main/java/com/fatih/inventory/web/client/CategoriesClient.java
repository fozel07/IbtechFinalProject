package com.fatih.inventory.web.client;

import java.io.InputStream;
import java.util.List;

import com.fatih.core.utils.WebHelper;
import com.fatih.inventory.Category;

import com.fatih.inventory.xml.CategoryXml;


public class CategoriesClient {
	
	
public List<Category>  Categories() throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/categories";
		
		InputStream in=WebHelper.get(address);
	
		List<Category> categoryList=CategoryXml.parseProductXmlList(in);
		
		return categoryList;				
	}
public Category  Category(long id) throws Exception {
	
	String address=String.format("http://localhost:8081/FatihFinalProject/api/category?categoryId=%d", id);
	
	InputStream in=WebHelper.get(address);

	Category category=CategoryXml.parseProductXml(in);
	
	return category;				
}

}
