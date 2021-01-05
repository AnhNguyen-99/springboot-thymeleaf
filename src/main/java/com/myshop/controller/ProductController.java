package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "manages/product")
public class ProductController {
	
	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_product";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		return "manages/form_product";
	}
	
	@RequestMapping(value = "/edit/{productId}")
	public String viewEdit(@PathVariable("productId")int productId) {
		return "manages/edit_product";
	}
}
