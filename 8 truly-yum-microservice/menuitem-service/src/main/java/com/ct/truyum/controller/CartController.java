package com.ct.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ct.truyum.exception.CartEmptyException;
import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.exception.UserNotExistsException;
import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	private final static Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/{userId}/{menuItemId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId)
			throws MenuItemNotFoundException {
		LOGGER.info("addCartItem CartService started...");
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("Added to Cart");
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId)
			throws CartEmptyException, UserNotExistsException {
		LOGGER.info("getAllCartItems CartService started...");
		List<MenuItem> list = cartService.getAllCartItems(userId);
		LOGGER.debug("Menu Items for User " + userId + " are {} ", list);
		return list;

	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId)
			throws UserNotExistsException, CartEmptyException, MenuItemNotFoundException {
		LOGGER.info("deleteCartItem CartService started...");
		cartService.deleteCartItem(userId, menuItemId);
		LOGGER.debug("Cart Item deleted");
	}

}
