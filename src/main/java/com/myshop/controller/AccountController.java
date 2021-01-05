package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "manages/account")
public class AccountController {

	@RequestMapping(value = "/list_customer")
	public String viewListCustomer(Model model) {
//		model.addAttribute("listCustomer", accountService.getListAccountByRoleId(2));
		return "manages/list_account_customer";
	}
	
	@RequestMapping(value = "/list_manages")
	public String viewListManages(Model model) {
//		model.addAttribute("listManages", accountService.getListAccountByRoleId(1));
		return "manages/list_account_manages";
	}
	
	// Tạo tài khoản
	@RequestMapping(value = "/create_manages")
	public String viewCreateManages() {
		return "manages/form_account_manages";
	}
	
	// Reset mật khẩu
	@RequestMapping(value = "/reset_account")
	public String viewResetAccount() {
		return "manages/form_account_reset";
	}
	
}
