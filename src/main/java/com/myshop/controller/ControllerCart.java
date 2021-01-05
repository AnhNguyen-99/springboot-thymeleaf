package com.myshop.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Account;
import com.myshop.entity.OrderItem;
import com.myshop.entity.Orders;
import com.myshop.entity.Product;
import com.myshop.entity.StatusOrder;
import com.myshop.entity.Cart;
import com.myshop.repository.OrderItemRepository;
import com.myshop.repository.OrderRepository;
import com.myshop.repository.ProductRepository;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {

	@Autowired
	private ProductRepository productService;
	
	@Autowired
	private OrderRepository orderService;
	
	@Autowired
	private OrderItemRepository orderItemService;
	
	@RequestMapping(value = "/add/{productId}")
    public String viewAdd(@PathVariable("productId")int productId, Model model, HttpSession session){
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findByProductId(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "pages/cart";
	}
	
	private Float totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
        	if(list.getValue().getProduct().getProductSale() == 0)
        		count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
            else
            	count += (list.getValue().getProduct().getProductPrice() - (list.getValue().getProduct().getProductSale() * list.getValue().getProduct().getProductPrice())/100 ) * list.getValue().getQuantity();
        }
        return (float) count;
    }
	
	@RequestMapping(value = "/remove/{productId}")
	public String viewRemove(@PathVariable("productId")Integer productId, HttpSession session){
	    HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
	    if (cartItems == null) {
	        cartItems = new HashMap<>();
	    }
	    if (cartItems.containsKey(productId)) {
	        cartItems.remove(productId);
	    }
	    session.setAttribute("myCartItems", cartItems);
	    session.setAttribute("myCartTotal", totalPrice(cartItems));
	    session.setAttribute("myCartNum", cartItems.size());
	    return "pages/cart";
	}
	
	@RequestMapping(value = "/viewcart")
    public String viewCart(Model model, HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems.size() == 0){
        	model.addAttribute("listProduct", productService.findAll());
            return "page/index";
        }else{
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("myCartTotal", totalPrice(cartItems));
            session.setAttribute("myCartNum", cartItems.size());
            return "pages/cart";
        }
    }
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String viewCheckout(@ModelAttribute("order") Orders orders, Model model, HttpSession session) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if(cartItems == null)
			cartItems = new HashMap<>();
//		Account account = (Account) session.getAttribute("myLogin");
		Account account = new Account(1);
		Calendar calendar = Calendar.getInstance();
		orders.setAccount(account);
		orders.setOrderDate(calendar.getTime());
		StatusOrder statusorder = new StatusOrder(1);
		orders.setStatusorder(statusorder);
		orders.setTotalPrice(totalPrice(cartItems));
		orderService.save(orders);
		OrderItem orderItem = new OrderItem();
        orderItem.setOrders(orders);
		for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            orderItem.setProduct(entry.getValue().getProduct());
            orderItem.setPrice(entry.getValue().getProduct().getProductPrice() * entry.getValue().getQuantity());
            orderItem.setQuantity(entry.getValue().getQuantity());
            orderItemService.save(orderItem);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
		return "pages/order_complete";
	}
	
	@RequestMapping(value = "/checkout_complete")
	public String view() {
		return "pages/order_complete";
	}
	
}
