package com.ct.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ct.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	@Query(value="select * from menu_item where date_of_launch <=CURRENT_DATE() and active='Yes'",nativeQuery = true)
	List<MenuItem> findByActiveItems();
}
