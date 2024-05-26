package com.om.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

	
	private String itemname;
	private String itemcategory;
	private String itemdiscription;
	private Integer fk_userid;
}
