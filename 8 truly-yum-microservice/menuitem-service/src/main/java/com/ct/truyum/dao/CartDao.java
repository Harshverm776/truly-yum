package com.ct.truyum.dao;

import java.util.List;

import com.ct.truyum.exception.CartEmptyException;
import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.exception.UserNotExistsException;
import com.ct.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException, UserNotExistsException;

	public void deleteCartItem(String userId, long menuItemId)
			throws UserNotExistsException, CartEmptyException, MenuItemNotFoundException;
}
