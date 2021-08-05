package com.ct.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from menu");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
						resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> filteredList = new ArrayList<MenuItem>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from menu where item_date_of_launch < curdate() and item_active = '1'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
						resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
				filteredList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filteredList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update menu set item_name =  ? , item_price = ? , "
					+ " item_active =  ? , item_date_of_launch =  ? , item_category =  ? , item_free_delivery= ? " + "where item_id= ? ");
			preparedStatement.setString(1, menuItem.getName());
			preparedStatement.setFloat(2, menuItem.getPrice());
			preparedStatement.setBoolean(3, menuItem.isActive());
			preparedStatement.setDate(4, new Date(menuItem.getDateOfLaunch().getTime()));
			
			preparedStatement.setString(5, menuItem.getCategory());
			preparedStatement.setBoolean(6, menuItem.isFreeDelivery());
			preparedStatement.setLong(7, menuItem.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		MenuItem menuItem = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from menu where item_id =  ? ;");
			preparedStatement.setLong(1, menuItemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			menuItem =  new MenuItem(resultSet.getLong(1), resultSet.getString(2), resultSet.getFloat(3),
						resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuItem;
	}

}
