package com.ct.truyum.dao;

import java.util.*;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem item1 = new MenuItem(1L, "Sandwich", 99.00f, true, DateUtil.convertToDate("01/01/2021"),
					"Main Course", true);
			MenuItem item2 = new MenuItem(2L, "Burger", 129.00f, true, DateUtil.convertToDate("02/01/2021"),
					"Main Course", false);
			MenuItem item3 = new MenuItem(3L, "Pizza", 149.00f, true, DateUtil.convertToDate("05/01/2021"),
					"Main Course", false);
			MenuItem item4 = new MenuItem(4L, "French Fries", 57.00f, false, DateUtil.convertToDate("10/01/2021"),
					"Starters", true);
			MenuItem item5 = new MenuItem(5L, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("11/02/2021"),
					"Dessert", true);
			menuItemList.add(item1);
			menuItemList.add(item2);
			menuItemList.add(item3);
			menuItemList.add(item4);
			menuItemList.add(item5);

		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filteredList = new ArrayList<MenuItem>();
		Date today = new Date();
		Iterator<MenuItem> iterate = menuItemList.iterator();
		while (iterate.hasNext()) {
			MenuItem menuItem = iterate.next();
			if (menuItem.isActive() == true) {
				if (menuItem.getDateOfLaunch().compareTo(today) < 0) {
					filteredList.add(menuItem);
				}
			}
		}

		return filteredList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Iterator<MenuItem> iterate = menuItemList.iterator();
		while (iterate.hasNext()) {
			MenuItem menuItems = iterate.next();
			if (menuItems.getId() == menuItem.getId()) {
				menuItemList.set(menuItemList.indexOf(menuItems), menuItem);
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		Iterator<MenuItem> iterate = menuItemList.iterator();
		while (iterate.hasNext()) {
			menuItem = iterate.next();
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return menuItem;
	}
}
