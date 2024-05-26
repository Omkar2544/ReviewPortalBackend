package com.om.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.om.entity.ReviewEntity;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
	@Transactional
	@Query("from ReviewEntity r where r.fk_itemid = :itemid order by  r.creationtime DESC")
	public List<ReviewEntity> findReviewByItemid(Integer itemid);

	@Transactional
	@Query("select AVG(r.rating) from ReviewEntity r group by r.fk_itemid having r.fk_itemid=:itemid")
	public Double findAverageRating(Integer itemid);

	@Transactional
	@Query("from ReviewEntity r where r.fk_itemid= :fk_itemid and r.fk_userid= :fk_userid")
	public Optional<ReviewEntity> getReview(Integer fk_itemid, Integer fk_userid);

}
