package com.om.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.om.entity.ReviewUserEntity;

import jakarta.transaction.Transactional;

public interface UserReviewRepository extends JpaRepository<ReviewUserEntity, Integer> {

	
	@Query("from ReviewUserEntity r where r.username=?1")
	Optional<ReviewUserEntity> findByUsername(String username);

}
