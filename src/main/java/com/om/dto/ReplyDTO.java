package com.om.dto;

import lombok.Data;

@Data
public class ReplyDTO {

	private String username;
	private String reply;
	private Integer fk_itemid;
	private Integer fk_reviewid;
}
