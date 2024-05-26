package com.om.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.om.entity.ItemEntity;
import com.om.entity.ReplyEntity;

import jakarta.transaction.Transactional;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

	@Transactional
	@Query("from ReplyEntity r where r.fk_reviewid = :reviewId and r.fk_itemid= :itemId")
	List<ReplyEntity> findAllByReviewId(Integer reviewId,Integer itemId);

	

}
