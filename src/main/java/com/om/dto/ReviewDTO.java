package com.om.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {


	private Integer fk_userid;
	private Integer fk_itemid;
	private Double rating;
	private String review;
	private String fk_username;
}
