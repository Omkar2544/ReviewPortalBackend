package com.om.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
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
public class ReplyEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  replyid;
	private String username;
	@Column(length = 600)
	private String reply;
	
	private Integer fk_itemid;
	private Integer fk_reviewid;
	@CurrentTimestamp
	private LocalDateTime creationtime;
	
}
