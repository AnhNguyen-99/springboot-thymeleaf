package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manages/news")
public class NewsController {

	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_news";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate() {
		return "manages/form_news";
	}
	
	@RequestMapping(value = "/edit/{newsId}")
	public String viewEdit(@PathVariable("newsId") int newsId) {
		return "manages/edit_news";
	}
}
