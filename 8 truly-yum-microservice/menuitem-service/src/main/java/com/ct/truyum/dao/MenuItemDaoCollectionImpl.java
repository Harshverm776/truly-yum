package com.ct.truyum.dao;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.model.MenuItem;

@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;

	@PostConstruct
	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (ArrayList<MenuItem>) context.getBean("menuItemList");
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		return menuItemList;
	}

	@Override
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException {
		MenuItem menuItem = null;
		for (MenuItem item : menuItemList) {
			if (item.getId() == id) {
				menuItem = item;
				break;
			}
		}
		if (menuItem == null)
			throw new MenuItemNotFoundException("Menu Item Not Found");
		else
			return menuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		int index = 0;
		MenuItem menuItemExists = null;
		for (MenuItem item : menuItemList) {
			if (item.getId() == menuItem.getId()) {
				menuItemExists = item;
				break;
			}
			index++;
		}
		if (menuItemExists == null)
			throw new MenuItemNotFoundException("Menu Item id - " + menuItemExists.getId() + "Not Found");
		else {
			menuItemList.set(index, menuItem);
		}
	}

}
