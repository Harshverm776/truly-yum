package com.ct.truyum.dao;

import java.util.*;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) {
		//testGetMenuItemListAdmin();
		//testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> adminList = new ArrayList<MenuItem>();
		adminList.addAll(menuItemDao.getMenuItemListAdmin());
		Iterator<MenuItem> display = adminList.iterator();
		while (display.hasNext()) {
			System.out.println(display.next());
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> CustomerList = new ArrayList<MenuItem>();
		CustomerList.addAll(menuItemDao.getMenuItemListCustomer());
		Iterator<MenuItem> display = CustomerList.iterator();
		while (display.hasNext()) {
			System.out.println(display.next());
		}
	}

	public static void testModifyMenuItem() {
		MenuItem ModifyMenu = new MenuItem(1L, "Hot Dog", 99.00f, true, DateUtil.convertToDate("01/01/2021"),
				"Main Course", true);
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(ModifyMenu);
		System.out.println(menuItemDao.getMenuItem(1L));
	}
}
