package com.om.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ItemVO {


	private Integer itemid;
	private Integer fk_userid;
	private String itemname;
	private String itemcategory;
	private String itemdescription;
	private LocalDateTime creationtime;
	private Double averageRating;
	private String image;
}
