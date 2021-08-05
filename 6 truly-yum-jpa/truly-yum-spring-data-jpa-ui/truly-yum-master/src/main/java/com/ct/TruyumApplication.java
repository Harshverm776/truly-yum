package com.ct;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ct.truyum.App;
import com.ct.truyum.model.MenuItem;
import com.ct.truyum.service.MenuItemService;
import com.ct.truyum.util.DateUtil;

@SpringBootApplication
@ComponentScan("com.*")
public class TruyumApplication{
		@Autowired
		private static MenuItemService menuItemService;
		private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
		
		public static void main(String[] args) throws Exception {
			LOGGER.info("Inside main");
			ApplicationContext context=SpringApplication.run(TruyumApplication.class, args);
			
			menuItemService=context.getBean(MenuItemService.class);
//			testModifyItem();
//			testGetMenuItemListAdmin();
//			testGetMenuItemListCustomer();
//			testGetMenuItem(1l);
					
		}
		
		private static void testModifyItem() throws Exception//use this test to insert or update Menu ITem Object
		{
			MenuItem menuItem=menuItemService.getMenuItem(1l);
			//menuItem.setId(1l);
			menuItem.setName("Fries");
			menuItem.setPrice(30.00f);
			menuItem.setFreeDelivery("Yes");
			menuItem.setActive("Yes");
			menuItem.setDateOfLaunch(DateUtil.convertToDate("12/05/1998"));
			menuItem.setCategory("Starters");
			menuItemService.modifyMenuItem(menuItem);
			
		}
		private static void testGetMenuItemListAdmin()
		{
			LOGGER.info("Start");	
			LOGGER.debug("MenuItems {}",menuItemService.getMenuItemListAdmin());
			LOGGER.info("End");
		}
		
		private static void testGetMenuItemListCustomer()
		{
			LOGGER.info("Start");	
			LOGGER.debug("MenuItems for customer {}",menuItemService.getMenuItemListCustomer());
			LOGGER.info("End");
		}
		
		
		private static void testGetMenuItem(long id)
		{
			LOGGER.info("Start");	
			LOGGER.debug("Item:: {}",menuItemService.getMenuItem(id));
			LOGGER.info("End");
		}	
	}