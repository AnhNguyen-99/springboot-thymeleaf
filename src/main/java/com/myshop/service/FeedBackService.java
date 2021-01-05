package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.FeedBackConverter;
import com.myshop.dto.FeedBackDTO;
import com.myshop.entity.Feedback;
import com.myshop.repository.FeedBackRepository;

@Service
public class FeedBackService {

	@Autowired
	private FeedBackRepository feedBackRepository;
	
	public List<FeedBackDTO> getAll(){
		List<FeedBackDTO> listDTO = new ArrayList<>();
		List<Feedback> list = feedBackRepository.findAll();
		FeedBackConverter feedBackConverter = new FeedBackConverter();
		for (Feedback feedback : list) {
			FeedBackDTO feedBackDTO = feedBackConverter.toFeedBackDTO(feedback);
			listDTO.add(feedBackDTO);
		}
		return listDTO;
	}
	
	public FeedBackDTO findByFeedBackId(int feedBackId) {
		FeedBackConverter feedBackConverter = new FeedBackConverter();
		Feedback feedback = feedBackRepository.findByFeedbackId(feedBackId);
		return feedBackConverter.toFeedBackDTO(feedback);
	}
	
	public FeedBackDTO save(FeedBackDTO feedBackDTO) {
		Feedback feedback = new Feedback();
		Feedback oldFeedBack = new Feedback();
		FeedBackConverter feedBackConverter = new FeedBackConverter();
		if(feedBackDTO.getFeedBackId() != null) {
			oldFeedBack = feedBackRepository.findByFeedbackId(feedBackDTO.getFeedBackId());
			feedback = feedBackConverter.toFeedBackEntity(oldFeedBack, feedBackDTO);
		}else {
			feedback = feedBackConverter.toFeedBackEntity(feedBackDTO);
		}
		feedback = feedBackRepository.save(feedback);
		return feedBackConverter.toFeedBackDTO(feedback);
	}
}
