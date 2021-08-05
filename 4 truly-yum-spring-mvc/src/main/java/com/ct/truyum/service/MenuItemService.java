package com.ct.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ct.truyum.dao.MenuItemDao;
import com.ct.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	@Qualifier("menuItemDao")
	MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemDao.getMenuItemListAdmin();
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemDao.getMenuItemListCustomer();
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
	
}
	
	
	