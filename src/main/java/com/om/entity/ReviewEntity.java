package com.om.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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
public class ReviewEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer rid;
	
	private Integer fk_userid;
	private Integer fk_itemid;
	private Double rating;
	
	@Column(length = 600)
	private String review;
	
	private String fk_username;
	
	@CreationTimestamp
	private LocalDateTime creationtime;
}
