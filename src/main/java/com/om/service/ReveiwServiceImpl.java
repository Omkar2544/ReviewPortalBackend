package com.om.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.dao.ReviewDAOImpl;
import com.om.dto.CheckReviewDTO;
import com.om.dto.ItemDTO;
import com.om.dto.LoginDTO;
import com.om.dto.ReplyDTO;
import com.om.dto.ReviewDTO;
import com.om.dto.UserDTO;
import com.om.entity.ItemEntity;
import com.om.entity.ReplyEntity;
import com.om.entity.ReviewEntity;
import com.om.entity.ReviewUserEntity;
import com.om.repository.UserReviewRepository;
import com.om.vo.ItemVO;
import com.om.vo.ReviewVO;

@Service
public class ReveiwServiceImpl {
	
	@Autowired
	private ModelMapper mapper;
	

	@Autowired
	private ReviewDAOImpl reviewDAOImpl;

	public Boolean addUser(UserDTO userDTO) {
		ReviewUserEntity entity1 = new ReviewUserEntity();
		entity1.setUsername(userDTO.getUsername());
		entity1.setEmail(userDTO.getEmail());
		entity1.setPassword(userDTO.getPassword());
		
		return reviewDAOImpl.addUser(entity1);
		
	}

	public Boolean addItem(ItemDTO itemDTO) {
		System.out.println(itemDTO);
		ItemEntity entity1 = new ItemEntity();
		entity1.setFk_userid(itemDTO.getFk_userid());
		entity1.setItemcategory(itemDTO.getItemcategory());
		entity1.setItemdescription(itemDTO.getItemdiscription());
		entity1.setItemname(itemDTO.getItemname());
		
		System.out.println(entity1);
		return reviewDAOImpl.addItem(entity1);
		
	}

	public Boolean addReview(ReviewDTO reviewDTO) {
		
		ReviewEntity entity1 = new ReviewEntity();
		entity1.setFk_itemid(reviewDTO.getFk_itemid());
		entity1.setFk_userid(reviewDTO.getFk_userid());
		entity1.setFk_username(reviewDTO.getFk_username());
		entity1.setRating(reviewDTO.getRating());
		entity1.setReview(reviewDTO.getReview());
		
		return reviewDAOImpl.addReview(entity1);
		
		
	}

	public Boolean login(LoginDTO loginDTO) {
		Optional<ReviewUserEntity> entity1 = reviewDAOImpl.login(loginDTO.getUsername());
		if(entity1.isEmpty()) return false;
		
		
		
		if(entity1.get().getPassword().equals(loginDTO.getPassword())) return true;
		
		return false;
		
		
	}

	public List<ItemVO> getAllItems() {
		
		List<ItemEntity> entities = reviewDAOImpl.getAllItems();
		List<ItemVO> itemVO =  entities
				  .stream()
				  .map(ItemEntity -> mapper.map(ItemEntity, ItemVO.class))
				  .collect(Collectors.toList());
		
		for(ItemVO valueObj1: itemVO) {
			String checkCategory= valueObj1.getItemcategory().toLowerCase();
			if(checkCategory.equals("place"))valueObj1.setImage("assets/images/place.png");
			if(checkCategory.equals("book"))valueObj1.setImage("assets/images/book.png");
			if(checkCategory.equals("movie"))valueObj1.setImage("assets/images/movie.png");
			
			valueObj1.setAverageRating(reviewDAOImpl.getAverageRating(valueObj1.getItemid()));
		}
		 return itemVO;
		
	}

	public List<ReviewVO> getAllReviews(Integer itemid) {
		
		List<ReviewEntity> entity1= reviewDAOImpl.getAllReviews(itemid);
		
		List<ReviewVO> dtos = entity1
				  .stream()
				  .map(ReviewEntity -> mapper.map(ReviewEntity, ReviewVO.class))
				  .collect(Collectors.toList());
		
		for(ReviewVO itr: dtos) {
			List<ReplyEntity> rpEntity = this.getAllReplies(itr.getRid(), itr.getFk_itemid());
			itr.setReplyEntity(rpEntity);
		}
		 
		 return dtos;
	}

	public Boolean addReply(ReplyDTO replyDTO) {
		
	  ReplyEntity replyEntity = new ReplyEntity();
	  replyEntity.setFk_itemid(replyDTO.getFk_itemid());
	  replyEntity.setFk_reviewid(replyDTO.getFk_reviewid());
	  replyEntity.setReply(replyDTO.getReply());
	  replyEntity.setUsername(replyDTO.getUsername());
	  
	 return   reviewDAOImpl.addReview(replyEntity);
		
	}

	public List<ReplyEntity> getAllReplies(Integer reviewId,Integer itemId) {
		
	return reviewDAOImpl.getAllReplies(reviewId, itemId);
		
	}

	public List<ItemEntity> searchByItemName(String itemname) {
		return reviewDAOImpl.searchByItemName(itemname);
		
	}

	public List<ItemVO> searchByItemCategory(String itemcategory) {
				
		List<ItemEntity> entities = reviewDAOImpl.searchByItemCategory(itemcategory);
		List<ItemVO> itemVO =  entities
				  .stream()
				  .map(ItemEntity -> mapper.map(ItemEntity, ItemVO.class))
				  .collect(Collectors.toList());
		
		for(ItemVO valueObj1: itemVO) {
			String checkCategory= valueObj1.getItemcategory().toLowerCase();
			System.out.println(checkCategory);
			if(checkCategory.equals("place"))valueObj1.setImage("assets/images/place.png");
			if(checkCategory.equals("book"))valueObj1.setImage("assets/images/book.png");
			if(checkCategory.equals("movie"))valueObj1.setImage("assets/images/movie.png");
			
			valueObj1.setAverageRating(reviewDAOImpl.getAverageRating(valueObj1.getItemid()));
		}
		 return itemVO;
		
	}

	public ReviewUserEntity getUser(String username) {
		
		return reviewDAOImpl.login(username).get();
		
	}

	public Boolean checkIfReviewPresent(CheckReviewDTO checkReviewDTO) {

		 if(reviewDAOImpl.getReview(checkReviewDTO.getFk_itemid(),checkReviewDTO.getFk_userid()).isPresent()) return false;
		 
		 
		 return true;
		
	}

	
	
	
}
