package com.fatih.inventory.xml;

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

import com.fatih.shopping.CartViewHelper;

public class CartViewHelperXml {
	
	
	public static List<CartViewHelper> parseProductViewXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<CartViewHelper> productList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element categorys = document.getDocumentElement();
		NodeList nodeProduct = categorys.getElementsByTagName("Product");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementProduct = (Element) nodeProduct.item(i);
			long productId = getAttribute(elementProduct, "id", 0);
			long cartId =getSingleElementText(elementProduct, "cartId", 1);
			String productName =getSingleElementText(elementProduct, "productName", "");
			double salesQuantity = getSingleElementText(elementProduct, "salesQuantity", 1.1);
			double salesPrice = getSingleElementText(elementProduct, "salesPrice", 1.2);
			productList.add(new CartViewHelper(productId, cartId, productName, salesQuantity, salesPrice));
		}

		return productList;

	}
}
