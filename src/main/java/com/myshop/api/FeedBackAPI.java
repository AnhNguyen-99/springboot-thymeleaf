package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.FeedBackDTO;
import com.myshop.service.FeedBackService;

@RestController
@RequestMapping(value = "/api/feedback")
public class FeedBackAPI {

	@Autowired
	private FeedBackService feedBackService;
	
	@GetMapping("")
	public ResponseEntity<List<FeedBackDTO>> getAll(){
		List<FeedBackDTO> list = feedBackService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{feedBackId}")
	public ResponseEntity<FeedBackDTO> findById(@PathVariable("feedBackId")int feedBackId){
		FeedBackDTO feedBackDTO = feedBackService.findByFeedBackId(feedBackId);
		return ResponseEntity.ok().body(feedBackDTO);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createFeedBack(@RequestBody FeedBackDTO feedBackDTO){
		FeedBackDTO feedBackDTO2 = feedBackService.save(feedBackDTO);
		if(feedBackDTO2 == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(feedBackDTO2, HttpStatus.OK);
	}
	
	@GetMapping("/totalrecord")
	public ResponseEntity<?> totalRecord(){
		List<FeedBackDTO> list = feedBackService.getAll();
		int size = list.size();
		return ResponseEntity.ok().body(size);
	}
}
