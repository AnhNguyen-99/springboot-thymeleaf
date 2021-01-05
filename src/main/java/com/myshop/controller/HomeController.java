package com.myshop.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myshop.entity.Account;
//import com.myshop.service.AccountService;

import com.myshop.entity.Orders;
import com.myshop.repository.AccountRepository;

@Controller
public class HomeController {

	@Autowired
	private AccountRepository accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewInitLogin(Model model) {
		model.addAttribute("account", new Account());
		return "manages/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String viewLogin(@ModelAttribute("account") Account account, Model model, HttpSession session) {
		Account acc = accountService.login(account.getAccountName(), account.getAccountPass());
		if(acc == null) {
			model.addAttribute("account", new Account());
			session.setAttribute("myLogin", null);
		}
		session.setAttribute("myLogin", acc);
		return "redirect:homeLogin";
	}
	
	@RequestMapping(value = "/homeLogin")
	public String viewHomeLogin(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		if(account == null) {
			return "redirect:login";
		}else {
			return "redirect:manages/home";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String viewLogin(HttpSession session) {
		session.setAttribute("myLogin", null);
        return "redirect:home";
	}
	@RequestMapping(value = "manages/home")
	public String viewMangesHome(HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		if(account == null)
			return "redirect:login";
		else
			return "manages/index";
	}
		
	@RequestMapping(value = "/register")
	public String viewRegister() {
		return "manages/register";
	}
	
	@RequestMapping(value = "/home")
	public String viewHome() {
		return "pages/index";
	}
	
	@RequestMapping(value = "/about")
	public String viewAbout() {
		return "pages/about";
	}
	
	@RequestMapping(value = "/shop")
	public String viewShop() {
		return "pages/shop";
	}
	
	@RequestMapping(value = "/contact")
	public String viewContact() {
		return "pages/contact";
	}
	
	@RequestMapping(value = "/order_complete")
	public String viewOrderComplete() {
		return "pages/order_complete";
	}
	
	@RequestMapping(value = "/product-detail/{productId}")
	public String viewProductDetail(@PathVariable("productId")int productId) {
		return "pages/product_detail";
	}
	
	@RequestMapping(value = "/checkout")
	public String viewCheckout(Model model) {
		model.addAttribute("order", new Orders());
		return "pages/checkout";
	}
	
	@RequestMapping(value = "/cart")
	public String viewCart() {
		return "pages/cart";
	}
}
