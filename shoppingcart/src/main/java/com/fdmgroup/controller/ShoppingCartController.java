package com.fdmgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.persistence.ItemDao;

@Controller
public class ShoppingCartController {
	@Autowired
	private ItemDao dao;

	@GetMapping("/cart")
	public String cartPage() {
		return "cart";
	}
}
