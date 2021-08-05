
package com.ct.truyum.dao;

import java.util.List;

import com.ct.truyum.model.MenuItem;

public interface CartDao {

	void addCartItem(long userid, long menuItemId);

	List<MenuItem> getAllCartItems(long userid) throws CartEmptyException;

	void removeCartItem(long userId, long menuitemid);

}
