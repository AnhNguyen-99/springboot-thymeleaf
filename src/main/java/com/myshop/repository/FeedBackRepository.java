package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Feedback;

@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Integer>{

	Feedback findByFeedbackId(int feedBackId);
	
}
