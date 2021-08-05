package com.ct.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class MenuItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private long id;
	
	@Column(name="item_name")
	private String name;
	
	@Column(name="item_price")
	private double price;
	
	@Column(name="item_active")
	private String active;
	
	@Column(name="item_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name="item_category")
	private String category;
	
	@Column(name="item_free_delivery")
	private String freeDelivery;

	public MenuItem() {

	}

	public MenuItem(long id, String name, double price, String active, Date dateOfLaunch, String category,
			String freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public String isActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = (int) (prime * result + id);
		return result;

	}

	@Override
	public boolean equals(Object obj) {

		MenuItem other = (MenuItem) obj;

		if (id != other.id)
			return false;
		if (name.equals(other))
			return false;

		return true;
	}

}
