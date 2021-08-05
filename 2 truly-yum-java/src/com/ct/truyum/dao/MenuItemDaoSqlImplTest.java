package com.ct.truyum.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		ArrayList<MenuItem> adminList = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
		adminList.addAll(menuItemDao.getMenuItemListAdmin());
		Iterator<MenuItem> display = adminList.iterator();
		while (display.hasNext()) {
			System.out.println(display.next());

		}

	}

	public static void testGetMenuItemListCustomer() {
		ArrayList<MenuItem> CustomerList = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
		CustomerList.addAll(menuItemDao.getMenuItemListCustomer());
		Iterator<MenuItem> display = CustomerList.iterator();
		while (display.hasNext()) {
			System.out.println(display.next());

		}

	}

	public static void testModifyMenuItem() {
		MenuItem ModifyMenu = new MenuItem(1L, "Plain Dosa", 199.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(ModifyMenu);
		System.out.println(menuItemDao.getMenuItem(1L));

	}

	public static void testGetMenuItem() {

	}

}
