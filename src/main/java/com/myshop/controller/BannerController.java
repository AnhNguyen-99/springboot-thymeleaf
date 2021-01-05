package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manages/banner")
public class BannerController {

	@RequestMapping(value= "/list")
	public String viewList() {
		return "manages/list_banner";
	}
	
	@RequestMapping(value = "/edit/{bannerId}")
	public String viewEdit() {
		return "manages/edit_banner";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate() {
		return "manages/form_banner";
	}
}
