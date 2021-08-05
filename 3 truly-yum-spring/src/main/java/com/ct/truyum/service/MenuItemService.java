package com.ct.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.truyum.dao.MenuItemDao;
import com.ct.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemDao.getMenuItemListAdmin();

	}

	public List<MenuItem> getMenuItemListCustomer() {

		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(long menuitemId) {
		return menuItemDao.getMenuItem(menuitemId);
		
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);

	}


}
