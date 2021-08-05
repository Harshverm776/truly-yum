package com.ct.truyum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.truyum.dao.CartEmptyException;
import com.ct.truyum.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam long menuItemId,ModelMap model) {
		LOGGER.info("Start");
		cartService.addCartItem(1, menuItemId);
		model.addAttribute("addCartStatus", true);
		LOGGER.info("End");
		return "forward:/show-menu-list-customer";
	}
	
	@GetMapping("/show-cart")
	public String showCart(ModelMap model){
		LOGGER.info("Start");
		try {
			model.addAttribute("cart",cartService.getAllCartItems(1));
		} catch (CartEmptyException e) {
			return "cart-empty";
		}
		LOGGER.info("End");
		return "cart";
	}
	
	@GetMapping("/remove-cart-item")
	public String removeCart(@RequestParam long menuItemId, ModelMap model) {
	
		LOGGER.info("Start");
		cartService.removeCartItem(1, menuItemId);
		try {
			cartService.getAllCartItems(1);
		} catch (CartEmptyException e) {
			return "cart-empty";
		}
		model.addAttribute("removeCartItemStatus", true);
		LOGGER.info("End");
		return "forward:/show-cart";
	}
}
