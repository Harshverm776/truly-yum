package com.ct.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ct.truyum.exception.CartEmptyException;
import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.exception.UserNotExistsException;
import com.ct.truyum.model.Cart;
import com.ct.truyum.model.MenuItem;

@Service
public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = null;
		try {
			menuItem = menuItemDao.getMenuItem(menuItemId);
		} catch (MenuItemNotFoundException e) {
			e.printStackTrace();
		}

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException, UserNotExistsException {
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			} else {
				double total = 0.0;
				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			return menuItemList;
		} else {
			throw new UserNotExistsException("User with id " + userId + " does not exists");
		}

	}

	@Override
	public void deleteCartItem(String userId, long menuItemId)
			throws UserNotExistsException, CartEmptyException, MenuItemNotFoundException {
		if (userCarts.size() == 0)
			throw new UserNotExistsException("User with userid " + userId + " does not exist");
		if (userCarts.containsKey(userId)) {

			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			}
			boolean deleted = false;
			for (int i = 0; i < menuItemList.size(); i++) {
				if (menuItemList.get(i).getId() == menuItemId) {
					menuItemList.remove(i);
					deleted = true;
					break;
				}
			}
			if (!deleted)
				throw new MenuItemNotFoundException(
						"Menu Item with menuItemId " + menuItemId + " does not exists for User with userId " + userId);
		} else
			throw new UserNotExistsException("User with userid " + userId + " does not exist");

	}

}
