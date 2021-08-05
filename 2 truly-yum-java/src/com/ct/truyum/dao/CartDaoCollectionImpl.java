package com.ct.truyum.dao;

import java.util.*;

import com.ct.truyum.model.Cart;
import com.ct.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		ArrayList<MenuItem> cartItem = new ArrayList<MenuItem>();
		if (userCarts.containsKey(userId)) {
			cartItem.addAll(userCarts.get(userId).getMenuItemList());
			cartItem.add(menuItem);
			Cart cart = new Cart(0.0d, cartItem);
			userCarts.put(userId, cart);
		} else {
			cartItem.add(menuItem);
			Cart cart = new Cart(0.0d, cartItem);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> cartItem = new ArrayList<MenuItem>();
		double total = 0.0d;
		if (userCarts.containsKey(userId)) {
			cartItem.addAll(userCarts.get(userId).getMenuItemList());
		}
		if (cartItem.isEmpty()) {
			throw new CartEmptyException();
		}
		Iterator<MenuItem> iterate = cartItem.iterator();
		Cart cart = null;
		while (iterate.hasNext()) {
			MenuItem menuItem = iterate.next();
			total = total + menuItem.getPrice();
			cart = new Cart(total, cartItem);
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		ArrayList<MenuItem> removeCart = new ArrayList<MenuItem>();
		if (userCarts.containsKey(userId)) {
			removeCart.addAll(cart.getMenuItemList());
			for (int itr = 0; itr < removeCart.size(); itr++) {
				if (removeCart.get(itr).getId() == menuItemId) {
					removeCart.remove(itr);
					Cart cart1 = new Cart(0.0d, removeCart);
					userCarts.put(userId, cart1);
				}
			}
		}
	}

}
