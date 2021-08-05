package com.ct.truyum.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.truyum.exception.MenuItemNotFoundException;
import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	private final static Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping
	public ArrayList<MenuItem> getAllMenuItems() {
		LOGGER.info("getAllMenuItems MenuItemController started...");
		ArrayList<MenuItem> itemList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Item List {}", itemList);
		return itemList;
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) throws MenuItemNotFoundException {
		LOGGER.info("getMenuItem MenuItemController started...");
		MenuItem menuItem = menuItemService.getMenuItem(id);
		LOGGER.debug("Menu item {}", menuItem);
		return menuItem;
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException {
		LOGGER.info("modifyMenuItem MenuItemController started...");
		menuItemService.save(menuItem);
		LOGGER.debug("Modified item {}", menuItem);
		LOGGER.info("Modified");
	}

}
