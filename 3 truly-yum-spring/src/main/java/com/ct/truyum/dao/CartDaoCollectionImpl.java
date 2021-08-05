package com.ct.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ct.truyum.model.Cart;
import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.MenuItemService;

public class CartDaoCollectionImpl implements CartDao {

	private HashMap<Long, Cart> userCarts;

	public HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	public void addCartItem(long userid, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList;

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MenuItemService menutItemServiceBean = (MenuItemService) ctx.getBean("menutItemService");
		MenuItem menuItem = menutItemServiceBean.getMenuItem(menuItemId);
		Long userId = new Long(userid);
		userCarts = getUserCarts();

		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			menuItemList = cart.getMenuItemList();
			if (menuItemList == null)
				menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);

		} else {
			menuItemList = new CopyOnWriteArrayList<MenuItem>();
			menuItemList.add(menuItem);

			Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);

		}
		setUserCarts(userCarts);
		ctx.close();

	}

	@Override
	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {

		Cart cart = getUserCarts().get(new Long(userid));
		double total = 0.0;
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList == null || menuItemList.size() == 0) {
			throw new CartEmptyException("Cart is empty");
		}
		;
		for (MenuItem menuItem : menuItemList) {
			total = total + menuItem.getPrice();

		}
		cart.setTotal(total);

		// TODO Auto-generated method stub
		return menuItemList;
	}

	@SuppressWarnings("null")
	@Override
	public void removeCartItem(long userId, long menuitemid) {

		userCarts = getUserCarts();

		if (userCarts.containsKey(userId)) {

			Cart cart = userCarts.get(userId);

			List<MenuItem> menuItemList = cart.getMenuItemList();

			System.out.println("MenuItemList..0" + menuItemList);

			if (menuItemList != null || menuItemList.size() > 0) {
				for (int i = 0; i < menuItemList.size(); i++) {

					MenuItem menuItem = menuItemList.get(i);
					if (menuItem.getId() == menuitemid) {

						menuItemList.remove(menuItem);
						System.out.println("MenuItemList..1" + menuItemList);

					}

				}

			}
			System.out.println("MenuItemList..2" + menuItemList);

			cart.setMenuItemList(menuItemList);

			userCarts.put(userId, cart);

		}

	}

}
