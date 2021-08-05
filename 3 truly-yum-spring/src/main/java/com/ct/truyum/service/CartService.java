package com.ct.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.truyum.dao.CartDao;
import com.ct.truyum.dao.CartEmptyException;
import com.ct.truyum.model.MenuItem;

@Service
class CartService {

	@Autowired
	private CartDao cartDao;

	public void addCartItem(long userid, long menuItemId) {
		
		cartDao.addCartItem(userid, menuItemId);
		
	}

	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {
		
		return cartDao.getAllCartItems(userid);
		
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}



	public void removeCartItem(long userId, long menuitemid) {

		cartDao.removeCartItem(userId, menuitemid);

	}

}
