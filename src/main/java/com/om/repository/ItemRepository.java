package com.om.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.om.entity.ItemEntity;

import jakarta.transaction.Transactional;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

	@Transactional
	@Query("from ItemEntity i where i.itemcategory like %:itemname%")
	List<ItemEntity> findByItemname(String itemname);

	@Transactional
	@Query("from ItemEntity i where i.itemname like %:itemcategory%")
	List<ItemEntity> findByItemCategory(String itemcategory);

	

}
