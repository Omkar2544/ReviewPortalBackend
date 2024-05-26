package com.om.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.om.dto.CheckReviewDTO;
import com.om.dto.GetRepliesDTO;
import com.om.dto.ItemDTO;
import com.om.dto.LoginDTO;
import com.om.dto.ReplyDTO;
import com.om.dto.ReviewDTO;
import com.om.dto.UserDTO;
import com.om.entity.ItemEntity;
import com.om.entity.ReplyEntity;
import com.om.entity.ReviewEntity;
import com.om.entity.ReviewUserEntity;
import com.om.service.ReveiwServiceImpl;
import com.om.vo.ItemVO;
import com.om.vo.ReviewVO;

@RestController
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReveiwServiceImpl reviewService;
	
	@PostMapping("adduser")
	public Boolean addUser(@RequestBody UserDTO userDTO) {
		return reviewService.addUser(userDTO);
	}
	
	@PostMapping("additem")
	public Boolean addItem(@RequestBody ItemDTO itemDTO) {
		return reviewService.addItem(itemDTO);
	}
	
	@PostMapping("addreview")
	public Boolean addReview(@RequestBody ReviewDTO reviewDTO) {
		return reviewService.addReview(reviewDTO);
	}
	
	@PostMapping("login")
	public Boolean login(@RequestBody LoginDTO loginDTO) {
		
		return reviewService.login(loginDTO);
	}
	
	@GetMapping("getallitems")
	public List<ItemVO> getAllItems() {
	  return	reviewService.getAllItems();
	}
	
	@GetMapping("getallreviews/{itemid}")
	public List<ReviewVO> getAllReviews(@PathVariable Integer itemid) {
		return reviewService.getAllReviews(itemid);
	}
	
	@PostMapping("addreply")
	public Boolean addReply(@RequestBody ReplyDTO replyDTO) {
		return reviewService.addReply(replyDTO);
	}
	
	@PostMapping("getallreplies")
	public List<ReplyEntity> getAllReplies(@RequestBody GetRepliesDTO getRepliesDTO) {
	 return reviewService.getAllReplies(getRepliesDTO.getReviewId(),getRepliesDTO.getItemId());
	}
	
	@GetMapping("searchbyitemname/{itemname}")
	public List<ItemEntity> searchByItemName(@PathVariable String itemname) {
		return reviewService.searchByItemName(itemname);
	}
	
	@GetMapping("searchbyitemcategory/{itemcategory}")
	public List<ItemVO> searchByItemCategory(@PathVariable String itemcategory){
		return reviewService.searchByItemCategory(itemcategory);
	}
	
	@GetMapping("getuser/{username}")
	public  ReviewUserEntity getUser(@PathVariable String username) {
		return reviewService.getUser(username);
	}

	@PostMapping("checkifreviewpresent")
	public Boolean checkIfReveiwPresent(@RequestBody CheckReviewDTO checkReviewDTO){
		System.out.println(checkReviewDTO);
		return reviewService.checkIfReviewPresent(checkReviewDTO);	
	}
	
}
