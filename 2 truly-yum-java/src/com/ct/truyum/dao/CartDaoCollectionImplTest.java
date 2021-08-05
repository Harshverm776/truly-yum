package com.ct.truyum.dao;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1L, 1L);
		cartDao.addCartItem(1L, 2L);
		//cartDao.addCartItem(1L, 3L);
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1L, 2L);
		try {
			System.out.println(cartDao.getAllCartItems(1L));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}
}
