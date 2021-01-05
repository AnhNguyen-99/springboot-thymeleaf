//package com.myshop.service;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Service;
//
//import com.myshop.entity.CartItem;
//import com.myshop.repository.Cart;
//
//@Service
//public class CartManager {
//
//	private static final String SESSION_CART = "myCartItems";
//	
//	public Cart getCart(HttpSession session) {
//		Cart cart = (Cart) session.getAttribute(SESSION_CART);
//		if(cart == null) {
//			cart = new Cart();
//			setCart(session, cart);
//		}
//		return cart;
//	}
//	
//	public void setCart(HttpSession session, Cart cart) {
//		session.setAttribute(SESSION_CART, cart);
//	}
//	
//	public void removeCart(HttpSession session) {
//		session.removeAttribute(SESSION_CART);
//	}
//	
//	public double totalPrice(HttpSession session) {
//		double total = 0;
//		Cart cart = (Cart) session.getAttribute(SESSION_CART);
//		List<CartItem> list = cart.getItems();
//		for (CartItem cartItem : list) {
//			total = total + (cartItem.getProduct().getProductPrice() * cartItem.getQuantity());
//		}
//		return total;
//	}
//}
