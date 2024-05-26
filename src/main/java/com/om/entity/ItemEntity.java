package com.om.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer itemid;
	
	private Integer fk_userid;
	private String itemname;
	private String itemcategory;
	private String itemdescription;
	
	@CreationTimestamp
	private LocalDateTime creationtime;
	
}
