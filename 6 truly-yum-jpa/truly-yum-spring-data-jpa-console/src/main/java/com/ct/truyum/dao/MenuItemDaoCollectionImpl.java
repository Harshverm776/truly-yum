package com.ct.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ct.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	public List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCust = new ArrayList<MenuItem>();

		Date today = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= today.getTime() && (menuItem.isActive()=="Yes")) {
				menuItemListCust.add(menuItem);
			}
		}

		return menuItemListCust;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem menuItemForModification : menuItemList) {

			if (menuItem.getId() == menuItemForModification.getId()) {

				menuItemForModification.setName(menuItem.getName());
				menuItemForModification.setCategory(menuItem.getCategory());
				menuItemForModification.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuItemForModification.setFreeDelivery(menuItem.isFreeDelivery());
				menuItemForModification.setPrice(menuItem.getPrice());
				menuItemForModification.setActive(menuItem.isActive());
			}

		}

	}

	@Override
	public MenuItem getMenuItem(long menuitemId) {
		
		menuItemList = getMenuItemList();
		System.out.println("......" + menuItemList);

		for (MenuItem menuItem : menuItemList) {
			if (menuitemId == menuItem.getId()) {
				return menuItem;

			}

		}
		return null;

	}

}
