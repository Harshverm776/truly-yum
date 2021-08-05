package com.ct.truyum.dao;
//package com.ct.truyum.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.ct.truyum.model.MenuItem;
//
//@Component("menuItemDao")
//public class MenuItemDaoSqlImpl implements MenuItemDao {
//
//	@Override
//	public List<MenuItem> getMenuItemListAdmin() {
//		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
//		final String QUERY = "select * from menu_item";
//		try {
//			Connection con = ConnectionHandler.getConnection();
//			PreparedStatement stmt = con.prepareStatement(QUERY);
//			ResultSet result = stmt.executeQuery();
//			while (result.next()) {
//				long id = result.getLong("id");
//				String name = result.getString("name");
//				float price = result.getFloat("price");
//				String active = result.getString("active");
//				Date date = result.getDate("date_of_launch");
//				String category = result.getString("category");
//				String free_delivery = result.getString("free_delivery");
//				boolean act = false;
//				if (active.equalsIgnoreCase("yes")) {
//					act = true;
//				}
//				boolean free = false;
//				if (free_delivery.equalsIgnoreCase("yes")) {
//					free = true;
//				}
//				//MenuItem menuItem = new MenuItem(id, name, price, act, date, category, free);
//				menuItemList.add(menuItem);
//			}
//		} catch (SQLException | ClassNotFoundException e) {
//
//			e.printStackTrace();
//		}
//
//		return menuItemList;
//	}
//
//	@Override
//	public List<MenuItem> getMenuItemListCustomer() {
//		ArrayList<MenuItem> menuItemListCustomer = new ArrayList<MenuItem>();
//
//		final String Query = "select * from menu_item where active='Yes' AND date_of_launch < '2018-12-02'";
//		try {
//			Connection con = ConnectionHandler.getConnection();
//			PreparedStatement stmt = con.prepareStatement(Query);
//			ResultSet result = stmt.executeQuery();
//			while (result.next()) {
//				long id = result.getLong("id");
//				String name = result.getString("name");
//				float price = result.getFloat("price");
//				String active = result.getString("active");
//				Date date = result.getDate("date_of_launch");
//				String category = result.getString("category");
//				String free_delivery = result.getString("free_delivery");
//				boolean act = false;
//				if (active.equalsIgnoreCase("yes")) {
//					act = true;
//				}
//				boolean free = false;
//				if (free_delivery.equalsIgnoreCase("yes")) {
//					free = true;
//				}
//				MenuItem menuItem = new MenuItem(id, name, price, act, date, category, free);
//				menuItemListCustomer.add(menuItem);
//			}
//
//		} catch (SQLException | ClassNotFoundException e) {
//
//			e.printStackTrace();
//		}
//
//		return menuItemListCustomer;
//	}
//
//	@Override
//	public void modifyMenuItem(MenuItem menuItem) {
//
//		long id = menuItem.getId();
//		String name = menuItem.getName();
//		float price = menuItem.getPrice();
//		boolean active = menuItem.isActive();
//
//		java.sql.Date d = new java.sql.Date(menuItem.getDateOfLaunch().getTime());
//		String category = menuItem.getCategory();
//		boolean free = menuItem.isFreeDelivery();
//		String act;
//		if (active == true) {
//			act = "Yes";
//		} else {
//			act = "No";
//		}
//		String fd;
//		if (free == true) {
//			fd = "Yes";
//		} else {
//			fd = "No";
//		}
//		final String query = "update menu_item "
//				+ "set name = ?,price = ?, active = ?, date_of_launch = ?, category = ?, free_delivery = ? "
//				+ "where id = ?";
//		try {
//			Connection con = ConnectionHandler.getConnection();
//			PreparedStatement stmt = con.prepareStatement(query);
//			stmt.setString(1, name);
//			stmt.setFloat(2, price);
//			stmt.setString(3, act);
//			stmt.setDate(4, d);
//			stmt.setString(5, category);
//			stmt.setString(6, fd);
//			stmt.setLong(7, id);
//			stmt.executeUpdate();
//
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public MenuItem getMenuItem(long menuItemId) {
//		MenuItem item = null;
//		final String query = "select * from menu_item " + "where id=?";
//		try {
//			Connection con = ConnectionHandler.getConnection();
//			PreparedStatement stmt = con.prepareStatement(query);
//			stmt.setLong(1, menuItemId);
//
//			ResultSet result = stmt.executeQuery();
//			while (result.next()) {
//				long id = result.getLong("id");
//				String name = result.getString("name");
//				float price = result.getFloat("price");
//				String active = result.getString("active");
//				Date date = result.getDate("date_of_launch");
//				String category = result.getString("category");
//				String free_delivery = result.getString("free_delivery");
//				boolean act = false;
//				if (active.equalsIgnoreCase("yes")) {
//					act = true;
//				}
//				boolean free = false;
//				if (free_delivery.equalsIgnoreCase("yes")) {
//					free = true;
//				}
//				item = new MenuItem(id, name, price, act, date, category, free);
//			}
//
//		} catch (SQLException | ClassNotFoundException e) {
//
//			e.printStackTrace();
//		}
//		return item;
//	}
//
//}
