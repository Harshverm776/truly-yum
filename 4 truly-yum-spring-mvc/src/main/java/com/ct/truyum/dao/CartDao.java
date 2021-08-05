package com.ct.truyum.dao;


import com.ct.truyum.model.Cart;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId);
	public Cart getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);
}
