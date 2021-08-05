package com.ct.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.MenuItemService;

public class MenuItemServiceTest {

	MenuItemService menutItemServiceBean;
	ClassPathXmlApplicationContext context;

	@Before
	public void initializeService() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		menutItemServiceBean = (MenuItemService) context.getBean("menutItemService");
	
	}

	@Test
	public void testGetMenuItemListAdminSize() {

		List<MenuItem> menuItemList = menutItemServiceBean.getMenuItemListAdmin();
		assertEquals(5, menuItemList.size());

	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() {

		List<MenuItem> menuItemList = menutItemServiceBean.getMenuItemListAdmin();
		List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(i, menuItemList.get(i).getName());

		}

		assertEquals(5, menuItemList.size());
		assertTrue(menuItems.contains("Sandwich"));

	}

	@Test
	public void testGetMenuItemListCustomerSize() {

		List<MenuItem> menuItemList = menutItemServiceBean.getMenuItemListCustomer();
		assertEquals(4, menuItemList.size());

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {

		List<MenuItem> menuItemList = menutItemServiceBean.getMenuItemListAdmin();
		List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(i, menuItemList.get(i).getName());

		}

		assertFalse(!menuItems.contains("French Fries"));
		
	}

	@Test
	public void testGetMenuItem() {
		
		MenuItem menuItem = menutItemServiceBean.getMenuItem(1);
		assertTrue(menuItem.getName().equals("Sandwich"));
	}

	@Test
	public void testModifyMenuItem() {
	
		MenuItem menuItemBefore = menutItemServiceBean.getMenuItem(1);
		menuItemBefore.setName("Fruit Juice");
		
		menutItemServiceBean.modifyMenuItem(menuItemBefore);
		
		assertTrue(menuItemBefore.getName().equals("Fruit Juice"));
		
	}
}
