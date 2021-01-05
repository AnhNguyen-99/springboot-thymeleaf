package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "manages/order")
public class OrderController {

	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_order";
	}
	
	@RequestMapping(value = "/order-detail/{orderId}")
	public String viewOrderDetail(@PathVariable("orderId") int orderId) {
		return "manages/form_order";
	}
}
