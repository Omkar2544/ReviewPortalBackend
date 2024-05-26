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


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUserEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer userid;
	
	
	
	private String email;
	private String password;
	private String username;
	
	@CreationTimestamp
	private LocalDateTime creationtime;
	
}
