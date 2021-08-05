package com.ct.truyum.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MenuItem {
	
	@NotNull(message = "id should not be null")
	private long id;
	@NotNull
	@Size(min = 0, max = 200, message = "Maximum 200 characters are allowed")
	private String name;
	@NotNull
	@Min(value = 0,message = "Price should be positive")
	private float price;
	@NotNull
	private boolean active;
	@NotNull
	private Date dateOfLaunch;
	@NotNull
	private String category;
	@NotNull
	private boolean freeDelivery;

	public MenuItem() {
		log.info("MenuItem Default Constructor Called...");
	}
	
}
