package com.fatih.shopping.xml;

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

import com.fatih.shopping.Cart;

public class CartXml {
	public static Document format(Cart cart) throws Exception {
		Document document = create("Cart");
		Element pl = document.getDocumentElement();
		pl.setAttribute("id", Long.toString(cart.getCartId()));

		addSingleElementText(document, pl, "totalAmount", cart.getTotalAmount());	
		addSingleElementText(document, pl, "customerName", cart.getCustomerName());
		return document;
	}

	public static Cart parseCartXml(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element carts = document.getDocumentElement();
		long cartId = XmlHelper.getAttribute(carts, "id", 0);
		double totalAmount = XmlHelper.getSingleElementText(carts, "totalAmount", 0.1);
		String customerName = XmlHelper.getSingleElementText(carts, "customerName", "");
	
		Cart cart = new Cart(cartId,totalAmount,customerName);
		return cart;

	}

	public static List<Cart> parseProductXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<Cart> cartList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element carts = document.getDocumentElement();
		NodeList nodeProduct = carts.getElementsByTagName("Cart");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementCart = (Element) nodeProduct.item(i);
			long cartId = XmlHelper.getAttribute(elementCart, "id", 0);
			double totalAmount = XmlHelper.getSingleElementText(elementCart, "totalAmount", 0.1);
			String customerName = XmlHelper.getSingleElementText(elementCart, "customerName", "");
			
			cartList.add(new Cart(cartId,totalAmount,customerName));
		}

		return cartList;

	}

	public static Cart parse(Document document) throws ParserConfigurationException, SAXException, IOException {
		Element carts = document.getDocumentElement();
		long cartId = XmlHelper.getAttribute(carts, "id", 0);
		double totalAmount = XmlHelper.getSingleElementText(carts, "totalAmount", 0.1);
		String customerName = XmlHelper.getSingleElementText(carts, "customerName", "");
		
		Cart cart = new Cart(cartId,totalAmount,customerName);
		return cart;

	}

	public static Document format(List<Cart> cartList) throws ParserConfigurationException {
		Document document = create("Carts");

		for (Cart cart : cartList) {
			Element root = document.getDocumentElement();
			Element cartElement = XmlHelper.addSingleElementText(document, root, "Cart", "");

			cartElement.setAttribute("id", Long.toString(cart.getCartId()));
			addSingleElementText(document, cartElement, "totalAmount", cart.getTotalAmount());
			addSingleElementText(document, cartElement, "customerName", cart.getTotalAmount());
			
		}
		return document;
	}

}
