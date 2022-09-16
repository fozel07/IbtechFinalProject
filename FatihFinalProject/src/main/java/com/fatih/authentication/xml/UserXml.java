package com.fatih.authentication.xml;

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

import com.fatih.authentication.User;
import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Category;

public class UserXml {
	
	public static Document format(User user) throws Exception {
		Document document = create("User");
		Element pl = document.getDocumentElement();
		pl.setAttribute("id", Long.toString(user.getUserId()));

		addSingleElementText(document, pl, "userName", user.getUserName());		
		addSingleElementText(document, pl, "userPassword", user.getUserPassword());		
		return document;
	}

	public static User parseUserXml(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element users = document.getDocumentElement();
		long userId = XmlHelper.getAttribute(users, "id", 0);
		String userName = XmlHelper.getSingleElementText(users, "userName", "");
		String userPassword = XmlHelper.getSingleElementText(users, "userPassword", "");
	
		User user = new User(userId,userName,userPassword);
		return user;

	}

	public static List<User> parseUserXmlList(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		List<User> userList = new ArrayList<>();
		Document document = XmlHelper.parse(in);
		Element users = document.getDocumentElement();
		NodeList nodeProduct = users.getElementsByTagName("User");
		for (int i = 0; i < nodeProduct.getLength(); i++) {
			Element elementUser = (Element) nodeProduct.item(i);
			long userId = XmlHelper.getAttribute(elementUser, "id", 0);
			String userName = XmlHelper.getSingleElementText(elementUser, "userName", "");
			String userPassword = XmlHelper.getSingleElementText(elementUser, "userPassword", "");
			
			userList.add(new User(userId,userName,userPassword));
		}

		return userList;

	}

	public static User parse(Document document) throws ParserConfigurationException, SAXException, IOException {
		Element users = document.getDocumentElement();
		long userId = XmlHelper.getAttribute(users, "id", 0);
		String userName = XmlHelper.getSingleElementText(users, "userName", "");
		String userPassword = XmlHelper.getSingleElementText(users, "userPassword", "");
	
		User user = new User(userId,userName,userPassword);
		return user;
		
	}

	public static Document format(List<User> userList) throws ParserConfigurationException {
		Document document = create("Users");

		for (User user : userList) {
			Element root = document.getDocumentElement();
			Element userElement = XmlHelper.addSingleElementText(document, root, "User", "");

			userElement.setAttribute("id", Long.toString(user.getUserId()));
			addSingleElementText(document, userElement, "userName", user.getUserName());
			addSingleElementText(document, userElement, "userPassword", user.getUserPassword());
			
		}
		return document;
	}

}
