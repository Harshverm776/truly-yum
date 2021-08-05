package com.ct.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ct.truyum.model.Cart;
import com.ct.truyum.model.MenuItem;
@Component("cartItemDao")
public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {

		String Query = "insert into cart(cust_id, menu_id) " + "values (?,?) ";
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

		Cart cart = new Cart(menuItemList, 0);
		String query = "select * from menu_item JOIN cart ON menu_item.id = cart.menu_id where cart.cust_id = ?";
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			float value = 0.00f;
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				value = value + price;
				String active = rs.getString("active");
				Date date = rs.getDate("date_of_launch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if (active.equalsIgnoreCase("yes")) {
					act = true;
				}
				boolean free = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					free = true;
				}
				MenuItem menuItem = new MenuItem(id, name, price, act, date, category, free);
				menuItemList.add(menuItem);

			}
			
			if(menuItemList.isEmpty()) {
				throw new CartEmptyException("Cart is empty");
			}
			
			cart.setTotal(value);
			cart.setMenuItemList(menuItemList);
			

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		
		String query = "delete from  cart where cust_id = ? AND menu_id = ?";
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
