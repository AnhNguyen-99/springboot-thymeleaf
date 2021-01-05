//package com.myshop.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.myshop.entity.Product;
//import com.myshop.repository.Cart;
//import com.myshop.repository.ProductRepository;
//import com.myshop.service.CartManager;
//
//@Controller
//@RequestMapping("cart")
//public class CartController {
//
//	@Autowired
//	private CartManager cartManager;
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@RequestMapping(value = "/add/{productId}")
//	public String addCart(HttpSession session, @PathVariable("productId") int productId, @RequestParam(value="quantity", required=false, defaultValue="1") int quantity) {
//		Cart cart = cartManager.getCart(session);
//		Product product = productRepository.findByProductId(productId);
//		cart.addItem(product, quantity);
//		return "pages/cart";
//	}
//	
//	@RequestMapping(value = "/remove/{productId}")
//	public String viewRemove(HttpSession session, @PathVariable("productId") int productId) {
//		Cart cart = cartManager.getCart(session);
//		Product product = productRepository.findByProductId(productId);
//		cart.removeItem(product);
//		return "pages/cart";
//	}
//	
//	@RequestMapping(value = "/update/{productId}")
//	public String viewUpdateCart(HttpSession session, @PathVariable("productId") int productId, @RequestParam("quantity") int quantity) {
//		Cart cart = cartManager.getCart(session);
//		Product product = productRepository.findByProductId(productId);
//		cart.updateItem(product, quantity);
//		return "pages/cart";
//	}
//	
//}
