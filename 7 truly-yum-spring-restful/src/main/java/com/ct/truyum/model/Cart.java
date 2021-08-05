package com.ct.truyum.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	public Cart() {
		log.debug("Cart constructor started...");
	}


}
