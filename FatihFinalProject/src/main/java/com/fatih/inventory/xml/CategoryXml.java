package com.fatih.inventory.xml;

import static com.fatih.core.utils.XmlHelper.addSingleElementText;
import static com.fatih.core.utils.XmlHelper.create;
import static com.fatih.core.utils.XmlHelper.getAttribute;
import static com.fatih.core.utils.XmlHelper.getSingleElementText;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Category;


public class CategoryXml {
	public static Document format(Category category) throws Exception {
		Document document = create("Category");
		Element pl = document.getDocumentElement();
		pl.setAttribute("id", Long.toString(category.getCategoryId()));

		addSingleElementText(document, pl, "categoryName", category.getCategoryName());		
		return document;
	}

	public static Category parseProductXml(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element categorys = document.getDocumentElement();
		long categoryId = XmlHelper.getAttribute(categorys, "id", 0);
		String categoryName = XmlHelper.getSingleElementText(categorys, "categoryName", "");
	
		Category category = new Category(categoryId,categoryName);
		return category;

	}

	public static List<Category> parseProductXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<Category> categoryList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element categorys = document.getDocumentElement();
		NodeList nodeProduct = categorys.getElementsByTagName("Category");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementProduct = (Element) nodeProduct.item(i);
			long categoryId = getAttribute(elementProduct, "id", 0);
			String categoryName =getSingleElementText(elementProduct, "categoryName", "");
			
			categoryList.add(new Category(categoryId, categoryName));
		}

		return categoryList;

	}

	public static Category parse(Document document) throws ParserConfigurationException, SAXException, IOException {
		Element categorys = document.getDocumentElement();
		long categoryId = XmlHelper.getAttribute(categorys, "id", 0);
		String categoryName = XmlHelper.getSingleElementText(categorys, "categoryName", "");
		
		Category category = new Category(categoryId, categoryName);
		return category;

	}

	public static Document format(List<Category> categoryList) throws ParserConfigurationException {
		Document document = create("Categorys");

		for (Category category : categoryList) {
			Element root = document.getDocumentElement();
			Element categoryElement = XmlHelper.addSingleElementText(document, root, "Category", "");

			categoryElement.setAttribute("id", Long.toString(category.getCategoryId()));
			addSingleElementText(document, categoryElement, "categoryName", category.getCategoryName());
			
		}
		return document;
	}

}
