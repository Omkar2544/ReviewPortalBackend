package com.om.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.om.entity.ItemEntity;
import com.om.entity.ReplyEntity;
import com.om.entity.ReviewEntity;
import com.om.entity.ReviewUserEntity;
import com.om.repository.ItemRepository;
import com.om.repository.ReplyRepository;
import com.om.repository.ReviewRepository;
import com.om.repository.UserReviewRepository;

@Repository
public class ReviewDAOImpl {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private UserReviewRepository userReviewRepository;
	@Autowired
	private ReplyRepository replyRepository;
	
	public Boolean addUser(ReviewUserEntity entity1) {
	
		ReviewUserEntity entity= userReviewRepository.save(entity1);
		
		if(entity.getEmail().equals(entity1.getEmail()))return true;
		
		return false;
		
	}
	public Boolean addItem(ItemEntity entity1) {
		ItemEntity entity= itemRepository.save(entity1);
		
		if(entity.getItemid()>0)return true;
		return false;
	}
	public Boolean addReview(ReviewEntity entity1) {
		ReviewEntity entity= reviewRepository.save(entity1);
		
		if(entity.getRid()>0)return true;
		return false;
	}
	public Optional<ReviewUserEntity> login(String username) {
		return userReviewRepository.findByUsername(username);
		
	}
	public List<ItemEntity> getAllItems() {
		
		return itemRepository.findAll();
		
	}
	public List<ReviewEntity> getAllReviews(Integer itemid) {
		
		return reviewRepository.findReviewByItemid(itemid);
		
	}
	public Boolean addReview(ReplyEntity replyEntity) {
		
	 ReplyEntity r1= 	replyRepository.save(replyEntity);
		if(r1.getReplyid()>0)return true;
		return false;
	}
	public List<ReplyEntity> getAllReplies(Integer reviewId,Integer itemId) {
		
	 return	replyRepository.findAllByReviewId(reviewId, itemId);
		
	}
	public List<ItemEntity> searchByItemName(String itemname) {
		return itemRepository.findByItemname(itemname);
	}
	public List<ItemEntity> searchByItemCategory(String itemcategory) {
		
		return itemRepository.findByItemCategory(itemcategory);
	}
	public Double getAverageRating(Integer itemid) {
		return reviewRepository.findAverageRating(itemid);
		
	}
	public Optional<ReviewEntity> getReview(Integer fk_itemid, Integer fk_userid) {
		
		return reviewRepository.getReview(fk_itemid,fk_userid);
		
	}
	
	
	
	
}
