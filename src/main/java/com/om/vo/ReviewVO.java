package com.om.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.om.entity.ReplyEntity;

import lombok.Data;

@Data
public class ReviewVO {

	private Integer rid;
	private Integer fk_itemid;
	private Integer fk_userid;
	private Double rating;
	private String review;
	private String fk_username;
	private LocalDateTime creationtime;
	
	private List<ReplyEntity> replyEntity;
}
