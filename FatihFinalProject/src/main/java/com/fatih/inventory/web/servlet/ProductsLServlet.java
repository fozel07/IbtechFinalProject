package com.fatih.inventory.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Product;
import com.fatih.inventory.xml.ProductXml;
import com.fatih.inventoryManager.ProductManager;



//list product api//
@WebServlet("/api/product")
public class ProductsLServlet extends HttpServlet {
	@Override
	protected void doGet (HttpServletRequest request , HttpServletResponse response)
	throws ServletException, IOException
	{
		if(request.getParameter("productId")!=null) {
		long productId = Long.parseLong(request.getParameter("productId"));
		ProductManager productManager=new ProductManager();
		List<Product> product;
		
		try {
			product = productManager.findProductByProductId(productId);
			Document document=ProductXml.format(product);
			
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		if(request.getParameter("categoryId")!=null) {
			long productId = Long.parseLong(request.getParameter("categoryId"));
			ProductManager productManager=new ProductManager();
			List<Product> product;
			
			try {
				product = productManager.findProductByCategory(productId);
				Document document=ProductXml.format(product);
				
				response.setContentType("application/xml; charset=UTF-8");
				XmlHelper.dump(document, response.getOutputStream());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
		
		
		
	
		
		
	}

}
