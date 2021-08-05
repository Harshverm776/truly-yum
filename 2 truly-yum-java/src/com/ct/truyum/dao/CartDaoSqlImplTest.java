package com.ct.truyum.dao;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {
		testAddCartItem();
		testGetAllCartItems();
	    testRemoveCartItem();

	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1L, 1L);
		cartDao.addCartItem(1L, 2L);
		cartDao.addCartItem(1L, 3L);
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
		
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoSqlImpl();
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
		
	}

	private static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1L, 3L);
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
		
	}

}
