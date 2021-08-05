package com.ct.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ct.truyum.model.Cart;
import com.ct.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into cart (user_id,item_id) values( ?,? );");
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		Cart cart = new Cart(0.0d,new ArrayList<MenuItem>());
		
		//ArrayList<MenuItem> cartItem = new ArrayList<MenuItem>();
		//double total = 0.0d;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select *from menu inner"
					+ " join cart on cart.item_id=menu.item_id where cart.user_id=?;");
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem item = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
						resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
				cart.getMenuItemList().add(item);
			}
			preparedStatement = connection.prepareStatement("select sum(item_price) from cart inner join menu on cart.item_id=menu.item_id where cart.user_id=?;");
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			cart.setTotal(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where user_id= ? and item_id= ?;");
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
