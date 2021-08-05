package com.ct.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MenuItemService.class);

	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");

	}

	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		return menuItemRepository.findById(menuItemId).get();

	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		return menuItemRepository.findByActiveItems();
	}

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		return menuItemRepository.findAll();
	}

}
