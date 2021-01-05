package com.myshop.converter;

import java.util.Calendar;

import com.myshop.dto.FeedBackDTO;
import com.myshop.entity.Feedback;

public class FeedBackConverter {

	public FeedBackDTO toFeedBackDTO(Feedback feedback) {
		FeedBackDTO feedBackDTO = new FeedBackDTO();
		Calendar calendar = Calendar.getInstance();
		feedBackDTO.setFeedBackId(feedback.getFeedbackId());
		feedBackDTO.setUsername(feedback.getUsername());
		feedBackDTO.setMobile(feedback.getMobile());
		feedBackDTO.setEmail(feedback.getEmail()); 
		feedBackDTO.setAddress(feedback.getAddress());
		feedBackDTO.setContent(feedback.getContent()); 
		feedBackDTO.setCreateDate(calendar.getTime());
		feedBackDTO.setUpdateDate(calendar.getTime());
		return feedBackDTO;
	}
	
	public Feedback toFeedBackEntity(FeedBackDTO feedBackDTO) {
		Feedback feedback = new Feedback();
		feedback.setUsername(feedBackDTO.getUsername());
		feedback.setMobile(feedBackDTO.getMobile());
		feedback.setEmail(feedBackDTO.getEmail()); 
		feedback.setAddress(feedBackDTO.getAddress());
		feedback.setContent(feedBackDTO.getContent()); 
		feedback.setCreateDate(feedBackDTO.getCreateDate());
		feedback.setUpdateDate(feedBackDTO.getUpdateDate());
		return feedback;
	}
	
	public Feedback toFeedBackEntity(Feedback feedback, FeedBackDTO feedBackDTO) {
		feedback.setUsername(feedBackDTO.getUsername());
		feedback.setMobile(feedBackDTO.getMobile());
		feedback.setEmail(feedBackDTO.getEmail()); 
		feedback.setAddress(feedBackDTO.getAddress());
		feedback.setContent(feedBackDTO.getContent()); 
		feedback.setCreateDate(feedBackDTO.getCreateDate());
		feedback.setUpdateDate(feedBackDTO.getUpdateDate());
		return feedback;
	}
}
