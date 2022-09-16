package com.fatih.inventory.xml;

import static com.fatih.core.utils.XmlHelper.*;


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
import com.fatih.inventory.Product;

public class ProductXml {
	public static Document format(Product product) throws Exception {
		Document document = create("Product");
		Element pl = document.getDocumentElement();
		pl.setAttribute("id", Long.toString(product.getProductId()));

		addSingleElementText(document, pl, "productName", product.getProductName());
		addSingleElementText(document, pl, "salesPrice", product.getSalesPrice());
		addSingleElementText(document, pl, "categoryId", product.getCategoryId());
		addSingleElementText(document, pl, "imagePath", product.getImagePath());
		return document;
	}

	public static Product parseProductXml(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element products = document.getDocumentElement();
		long productId = XmlHelper.getAttribute(products, "id", 0);
		String productName = XmlHelper.getSingleElementText(products, "productName", "");
		double salesPrice = XmlHelper.getSingleElementText(products, "salesPrice", 0.1);
		long categoryId = XmlHelper.getSingleElementText(products, "categoryId", 0);
		String imagePath = XmlHelper.getSingleElementText(products, "imagePath", "");
		Product product = new Product(productId, productName, salesPrice, categoryId, imagePath);
		return product;

	}

	public static List<Product> parseProductXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<Product> productList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element products = document.getDocumentElement();
		NodeList nodeProduct = products.getElementsByTagName("Product");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementProduct = (Element) nodeProduct.item(i);
			long productId = getAttribute(elementProduct, "id", 0);
			String productName =getSingleElementText(elementProduct, "productName", "");
			double salesPrice = getSingleElementText(elementProduct, "salesPrice", 1.1);
			long categoryId = getSingleElementText(elementProduct, "categoryId", 0);
			String imagePath = getSingleElementText(elementProduct, "imagePath", "");
			productList.add(new Product(productId, productName, salesPrice, categoryId, imagePath));
		}

		return productList;

	}

	public static Product parse(Document document) throws ParserConfigurationException, SAXException, IOException {
		Element products = document.getDocumentElement();
		long productId = XmlHelper.getAttribute(products, "id", 0);
		String productName = XmlHelper.getSingleElementText(products, "productName", "");
		double salesPrice = XmlHelper.getSingleElementText(products, "salesPrice", 0.1);
		long categoryId = XmlHelper.getSingleElementText(products, "categoryId", 0);
		String imagePath = XmlHelper.getSingleElementText(products, "imagePath", "");
		Product product = new Product(productId, productName, salesPrice, categoryId, imagePath);
		return product;

	}

	public static Document format(List<Product> productList) throws ParserConfigurationException {
		Document document = create("Products");

		for (Product product : productList) {
			Element root = document.getDocumentElement();
			Element productElement = XmlHelper.addSingleElementText(document, root, "Product", "");

			productElement.setAttribute("id", Long.toString(product.getProductId()));
			addSingleElementText(document, productElement, "productName", product.getProductName());
			addSingleElementText(document, productElement, "salesPrice", product.getSalesPrice());
			addSingleElementText(document, productElement, "categoryId", product.getCategoryId());
			addSingleElementText(document, productElement, "imagePath", product.getImagePath());
		}
		return document;
	}

}
