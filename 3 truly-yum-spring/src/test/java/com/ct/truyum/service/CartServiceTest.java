package com.ct.truyum.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ct.truyum.dao.CartEmptyException;
import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.CartService;

public class CartServiceTest {

	CartService cartServiceBean;
	ClassPathXmlApplicationContext context;

	@Before
	public void initializeSerive() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		cartServiceBean = (CartService) context.getBean("cartService");

	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItems() throws CartEmptyException {

	cartServiceBean.getAllCartItems(1);
	
	}

	@Test
	public void testAddCartItem() throws CartEmptyException {

		cartServiceBean.addCartItem(1, 1);
		List<MenuItem> menuItemList = cartServiceBean.getAllCartItems(1);

		List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(i, menuItemList.get(i).getName());

		}

		assertTrue(menuItems.contains("Sandwich"));

	}

	@Test
	public void testRemoveCartItem() throws CartEmptyException {

		cartServiceBean.addCartItem(1, 1);
		List<MenuItem> menuItemList = cartServiceBean.getAllCartItems(1);

		cartServiceBean.removeCartItem(1, 1);
		List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(i, menuItemList.get(i).getName());

		}

		assertTrue(!menuItems.contains("Sandwich"));

	}

}
