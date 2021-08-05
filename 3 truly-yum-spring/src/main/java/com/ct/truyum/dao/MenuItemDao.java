package com.ct.truyum.dao;

import java.util.List;

import com.ct.truyum.model.MenuItem;

public interface MenuItemDao {

	List<MenuItem> getMenuItemListAdmin();

	List<MenuItem> getMenuItemListCustomer();

	void modifyMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuitemId);

}
