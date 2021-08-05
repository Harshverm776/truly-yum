package com.ct.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.truyum.dao.CartDao;
import com.ct.truyum.exception.CartEmptyException;
import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.exception.UserNotExistsException;
import com.ct.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		cartDao.addCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException, UserNotExistsException {
		return cartDao.getAllCartItems(userId);
	}

	public void deleteCartItem(String userId, long menuItemId)
			throws UserNotExistsException, CartEmptyException, MenuItemNotFoundException {
		cartDao.deleteCartItem(userId, menuItemId);
	}
}
