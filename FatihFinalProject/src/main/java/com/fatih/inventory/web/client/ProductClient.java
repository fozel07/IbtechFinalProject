package com.fatih.inventory.web.client;

import java.io.InputStream;
import java.util.List;

import org.w3c.dom.Document;

import com.fatih.core.utils.WebHelper;
import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Category;
import com.fatih.inventory.Product;
import com.fatih.inventory.xml.CategoryXml;
import com.fatih.inventory.xml.ProductXml;


public class ProductClient {

	public  List<Product>  ProductsByCategory(long id) throws Exception {
		
		String address=String.format("http://localhost:8081/FatihFinalProject/api/product?categoryId=%d", id);
		
		InputStream in=WebHelper.get(address);
	
		List<Product> productList=ProductXml.parseProductXmlList(in);
		
		return productList;				
	}
	public  Product  ProductsByProductId(long id) throws Exception {
		
		String address=String.format("http://localhost:8081/FatihFinalProject/api/product?productId=%d", id);
		
		InputStream in=WebHelper.get(address);
	
		Product product=ProductXml.parseProductXml(in);
		
		return product;				
	}
	public List<Product>  Products() throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/products";
		
		InputStream in=WebHelper.get(address);
	
		List<Product> productList=ProductXml.parseProductXmlList(in);
		
		return productList;				
	}
	
}
