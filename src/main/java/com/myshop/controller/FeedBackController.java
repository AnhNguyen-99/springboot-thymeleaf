package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manages/feedback")
public class FeedBackController {

	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_feedback";
	}
	
	@RequestMapping(value = "/edit/{feedBackId}")
	public String viewEdit() {
		return "manages/edit_feedback";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate() {
		return "manages/form_feedback";
	}
}
