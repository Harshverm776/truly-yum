package com.ct.truyum.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ct.truyum.dao.CartDao;
import com.ct.truyum.dao.CartEmptyException;
import com.ct.truyum.model.Cart;

@Service("cartService")
public class CartService {
	@Autowired
	@Qualifier("cartItemDao")
	CartDao cartDao;
	
	public void addCartItem(long userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
