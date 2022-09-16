package com.fatih.shopping.xml;

import static com.fatih.core.utils.XmlHelper.addSingleElementText;
import static com.fatih.core.utils.XmlHelper.create;

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
import com.fatih.shopping.CartProduct;

public class CartProductXml {
	public static Document format(CartProduct cartProduct) throws Exception {
		Document document = create("CartProduct");
		Element pl = document.getDocumentElement();
		pl.setAttribute("id", Long.toString(cartProduct.getCartProductId()));

		addSingleElementText(document, pl, "cartId", cartProduct.getCartId());	
		addSingleElementText(document, pl, "productId", cartProduct.getPorductId());
		addSingleElementText(document, pl, "salesQuantity", cartProduct.getSalesQuantity());
		addSingleElementText(document, pl, "salesPrice", cartProduct.getSalesPrice());
		return document;
	}

	public static CartProduct parseCartProductXml(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element cartProducts = document.getDocumentElement();
		long CartProductId = XmlHelper.getAttribute(cartProducts, "id", 0);
		
		long cartId = XmlHelper.getSingleElementText(cartProducts, "cartId", 1);
		long productId = XmlHelper.getSingleElementText(cartProducts, "productId", 1);
		double salesQuantity = XmlHelper.getSingleElementText(cartProducts, "salesQuantity", 0.1);
		double salesPrice = XmlHelper.getSingleElementText(cartProducts, "salesPrice", 0.1);
	
		CartProduct cartProduct = new CartProduct(CartProductId,cartId,productId,salesQuantity,salesPrice);
		return cartProduct;

	}

	public static List<CartProduct> parseCartProductXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<CartProduct> cartProductList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element cartProducts = document.getDocumentElement();
		NodeList nodeProduct = cartProducts.getElementsByTagName("CartProduct");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementCart = (Element) nodeProduct.item(i);
			long CartProductId = XmlHelper.getAttribute(elementCart, "id", 0);
			
			long cartId = XmlHelper.getSingleElementText(cartProducts, "cartId", 1);
			long productId = XmlHelper.getSingleElementText(cartProducts, "productId", 1);
			double salesQuantity = XmlHelper.getSingleElementText(cartProducts, "salesQuantity", 0.1);
			double salesPrice = XmlHelper.getSingleElementText(cartProducts, "salesPrice", 0.1);
			
			cartProductList.add(new CartProduct(CartProductId,cartId,productId,salesQuantity,salesPrice));
		}

		return cartProductList;

	}

	public static CartProduct parse(Document document) throws ParserConfigurationException, SAXException, IOException {
		Element cartProducts = document.getDocumentElement();
		long CartProductId = XmlHelper.getAttribute(cartProducts, "id", 0);
		
		long cartId = XmlHelper.getSingleElementText(cartProducts, "cartId", 1);
		long productId = XmlHelper.getSingleElementText(cartProducts, "productId", 1);
		double salesQuantity = XmlHelper.getSingleElementText(cartProducts, "salesQuantity", 0.1);
		double salesPrice = XmlHelper.getSingleElementText(cartProducts, "salesPrice", 0.1);
		
		CartProduct cartProduct =new CartProduct(CartProductId,cartId,productId,salesQuantity,salesPrice);
		return cartProduct;

	}

	public static Document format(List<CartProduct> cartProductList) throws ParserConfigurationException {
		Document document = create("Carts");

		for (CartProduct cartProduct : cartProductList) {
			Element root = document.getDocumentElement();
			Element cartElement = XmlHelper.addSingleElementText(document, root, "CartProduct", "");

			cartElement.setAttribute("id", Long.toString(cartProduct.getCartProductId()));
			addSingleElementText(document, cartElement, "cartId", cartProduct.getCartId());
			addSingleElementText(document, cartElement, "productId", cartProduct.getPorductId());
			addSingleElementText(document, cartElement, "salesQuantity", cartProduct.getSalesQuantity());
			addSingleElementText(document, cartElement, "salesPrice", cartProduct.getSalesPrice());
			
		}
		return document;
	}

}
