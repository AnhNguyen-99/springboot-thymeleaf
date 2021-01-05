package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.service.CategoryService;

@Controller
@RequestMapping(value = "manages/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_category";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		return "manages/form_category";
	}
	
	@RequestMapping(value = "/edit/{categoryId}")
	public String viewEdit(@PathVariable("categoryId")int categoryId, Model model) {
		model.addAttribute("category", categoryService.findByCategoryId(categoryId));
		return "manages/edit_category";
	}
}
