package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.entity.Producer;

@Controller
@RequestMapping("manages/producer")
public class ProducerController {

	@RequestMapping(value = "/list")
	public String viewList() {
		return "manages/list_producer";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		model.addAttribute("producer", new Producer());
		return "manages/form_producer";
	}
	
	@RequestMapping(value = "/edit/{producerId}")
	public String viewEdit(@PathVariable("producerId") int producerId) {
		return "manages/edit_producer";
	}
	
	@RequestMapping(value = "/delete/{producerId}")
	public String viewDelete() {
		return "manages/list_producer";
	}
}
