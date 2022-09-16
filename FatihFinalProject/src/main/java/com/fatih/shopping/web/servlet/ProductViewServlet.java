package com.fatih.shopping.web.servlet;

import static com.fatih.core.utils.XmlHelper.addSingleElementText;
import static com.fatih.core.utils.XmlHelper.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Product;
import com.fatih.inventoryManager.ProductManager;
import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;
import com.fatih.shopping.xml.CartXml;
import com.fatih.shoppingManager.CartManager;
import com.fatih.shoppingManager.CartProductManager;

@WebServlet("/api/cart/view")
public class ProductViewServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("cartId")!=null) {
			
			
			
			
			
			
		
		try {
			
			Long cartId  = Long.parseLong(request.getParameter("cartId"));
			CartManager cartManager = new CartManager();
			Cart cart=cartManager.find(cartId);
			
			CartProductManager cartProductManager=new CartProductManager();
			List<CartProduct> productList=cartProductManager.listByCartId(cartId);
			
			ProductManager productManager=new ProductManager();
			
			Document document = create("Products");

			for (CartProduct cartProduct : productList) {
				Element root = document.getDocumentElement();
				Element productElement = XmlHelper.addSingleElementText(document, root, "Product", "");
				long productId=cartProduct.getPorductId();
				productElement.setAttribute("id", Long.toString(productId));
				addSingleElementText(document, productElement, "cartId",cartProduct.getCartId() );
				addSingleElementText(document, productElement, "productName", productManager.find(productId).getProductName());
				addSingleElementText(document, productElement, "salesQuantity", cartProduct.getSalesQuantity());
				addSingleElementText(document, productElement, "salesPrice", cartProduct.getSalesPrice());

			}
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
 }

}
