package com.fatih.inventory.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Category;
import com.fatih.inventory.xml.CategoryXml;
import com.fatih.inventoryManager.CategoryManager;


@WebServlet("/api/categories")
public class CategoriesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryManager categoryManager = new CategoryManager();
		List<Category> category;

		try {
			category = categoryManager.list();
			Document document = CategoryXml.format(category);

			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
