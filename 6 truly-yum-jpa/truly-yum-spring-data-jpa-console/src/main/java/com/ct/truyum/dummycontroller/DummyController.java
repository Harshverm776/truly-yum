package com.ct.truyum.dummycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class DummyController {
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping
	public List<MenuItem> getMenuItemList() {
		return menuItemService.getMenuItemListAdmin();
	}
	
	@PostMapping
	public void saveMenuItem(@RequestBody MenuItem menuitem) {
		menuItemService.modifyMenuItem(menuitem);
	}
}
